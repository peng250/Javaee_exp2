package cn.edu.xmu.jxt.exp.dao;

import cn.edu.xmu.jxt.exp.dao.bo.Order;
import cn.edu.xmu.jxt.exp.mapper.OrderMapper;
import cn.edu.xmu.jxt.exp.util.BusinessException;
import cn.edu.xmu.jxt.exp.util.ReturnNo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

@Repository
public class OrderDao {

    private Logger logger= LoggerFactory.getLogger(OrderDao.class);

    private OrderMapper orderMapper;


    @Autowired
    public OrderDao(OrderMapper orderMapper) {
        this.orderMapper = orderMapper;
    }

    public Order retrieveOrderByID(Long OrderId) throws BusinessException {
        Order order=null;
        try{
            order = orderMapper.selectByPrimaryKey(OrderId);
            if(null==order){
                throw new BusinessException(ReturnNo.RESOURCE_ID_NOTEXIST, "订单id不存在");
            }
            logger.debug("retrieveOrderByID: order = {}",  order);
        }catch (DataAccessException e){
            logger.error(e.getMessage());
            throw new BusinessException(ReturnNo.INTERNAL_SERVER_ERR,"数据库访问错误");
        }
        return order;
    }

}
