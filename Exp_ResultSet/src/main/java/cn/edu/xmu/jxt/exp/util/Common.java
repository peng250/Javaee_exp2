//School of Informatics Xiamen University, GPL-3.0 license
package cn.edu.xmu.jxt.exp.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/**
 * 通用工具类
 * @author Ming Qiu
 **/
public class Common {

    private static Logger logger = LoggerFactory.getLogger(Common.class);

    private static Pattern setPattern = Pattern.compile("set[A-Z][a-z][a-zA-Z0-9]*");

    private static Pattern getPattern = Pattern.compile("get[A-Z][a-z][a-zA-Z0-9]*");

    private static Pattern firstCharPattern = Pattern.compile("^.");

    /**
     * 根据 errCode 修饰 API 返回对象的 HTTP Status
     *
     * @param data 原返回 Object
     * @param e BusinessException
     * @return 修饰后的返回 Object
     */
    public static Object returnWithStatus(Object data, BusinessException e) {
        if (null != e){
            ReturnNo code = e.getErrno();
            switch (code) {
                case RESOURCE_ID_NOTEXIST:
                    // 404：资源不存在
                    return new ResponseEntity(
                            ResponseUtil.fail(code, e.getMessage()),
                            HttpStatus.NOT_FOUND);

                case AUTH_INVALID_JWT:
                case AUTH_JWT_EXPIRED:
                    // 401
                    return new ResponseEntity(
                            ResponseUtil.fail(code, e.getMessage()),
                            HttpStatus.UNAUTHORIZED);

                case INTERNAL_SERVER_ERR:
                    // 500：数据库或其他严重错误
                    return new ResponseEntity(
                            ResponseUtil.fail(code, e.getMessage()),
                            HttpStatus.INTERNAL_SERVER_ERROR);

                case FIELD_NOTVALID:
                case IMG_FORMAT_ERROR:
                case IMG_SIZE_EXCEED:
                case PARAMETER_MISSED:
                    // 400
                    return new ResponseEntity(
                            ResponseUtil.fail(code, e.getMessage()),
                            HttpStatus.BAD_REQUEST);

                case RESOURCE_ID_OUTSCOPE:
                case FILE_NO_WRITE_PERMISSION:
                    // 403
                    return new ResponseEntity(
                            ResponseUtil.fail(code, e.getMessage()),
                            HttpStatus.FORBIDDEN);
                default:
                    if (null != data) {
                        return ResponseUtil.fail(code, e.getMessage(), data);
                    } else {
                        return ResponseUtil.fail(code, e.getMessage());
                    }

            }
        }
        else{
            // 200: 无错误
            if (data != null) {
                return ResponseUtil.ok(data);
            } else {
                return ResponseUtil.ok();
            }
        }
    }


    public static <T> T cloneObj(Object source, Class<T> targetClass) {
        logger.debug("cloneObj: source = {}",source);
        Class sourceClass = source.getClass();
        T retObj = null;
        try {
            //默认targetClass有无参构造函数
            T targetObj = targetClass.getConstructor().newInstance();
            List<Method> sourceGetters = Arrays.stream(sourceClass.getMethods())
                    .filter(method -> getPattern.matcher(method.getName()).matches()
                            && (0 == method.getParameterCount())
                            && !method.getDeclaringClass().equals(Object.class))
                    .collect(Collectors.toList());

            Arrays.stream(targetClass.getMethods())
                    .filter(method -> (setPattern.matcher(method.getName()).matches()
                            && (1 == method.getParameterCount())
                            && !method.getDeclaringClass().equals(Object.class)))
                    .forEach(targetMethod -> {
                        logger.debug("cloneObj: setter = {}",targetMethod.getName());
                        String name = String.format("get%s", targetMethod.getName().substring(3));
                        sourceGetters.stream().filter(method -> method.getName().equals(name)).
                                forEach(sourceMethod -> {
                                    Object value = null;
                                    try {
                                        value = sourceMethod.invoke(source);
                                    } catch (Exception e) {
                                        logger.info("cloneObj: source object getter exception={}, name = {}", e, sourceMethod.getName());
                                    }
                                    logger.debug("cloneObj: getter = {}, value = {}",name, value);
                                    try {
                                        targetMethod.invoke(targetObj, value);
                                    } catch (Exception e2) {
                                        logger.info("cloneObj: target object setter exception={}, name = {}, value = {}", e2, targetMethod.getName(), value);
                                    }
                                });
                    });
            retObj = targetObj;
        }catch (Exception e){
            logger.error("cloneObj: create target object Exception = {}", e);
        }
        return retObj;
    }

}
