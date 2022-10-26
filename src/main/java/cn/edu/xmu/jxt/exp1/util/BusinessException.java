//School of Informatics Xiamen University, GPL-3.0 license
package cn.edu.xmu.jxt.exp1.util;

public class BusinessException extends RuntimeException{

    private ReturnNo errno;

    public BusinessException(ReturnNo errno, String message) {
        super(message);
        this.errno = errno;
    }

    public BusinessException(ReturnNo errno) {
        super(errno.getMessage());
        this.errno = errno;
    }

    public ReturnNo getErrno() {
        return errno;
    }
}
