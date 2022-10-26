package cn.edu.xmu.jxt.exp1.dao;

import cn.edu.xmu.jxt.exp1.dao.bo.Order;
import cn.edu.xmu.jxt.exp1.mapper.generator.OrderPoMapper;
import cn.edu.xmu.jxt.exp1.mapper.generator.po.OrderItemPo;
import cn.edu.xmu.jxt.exp1.mapper.generator.po.OrderPo;
import cn.edu.xmu.jxt.exp1.util.BusinessException;
import cn.edu.xmu.jxt.exp1.util.ReturnNo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class OrderDao {

    private Logger logger= LoggerFactory.getLogger(OrderDao.class);

    private OrderPoMapper orderPoMapper;

    private OrderItemDao orderItemDao;


    @Autowired
    public OrderDao(OrderPoMapper orderPoMapper, OrderItemDao orderItemDao) {
        this.orderPoMapper = orderPoMapper;
        this.orderItemDao = orderItemDao;
    }

    public Order retrieveOrderByID(Long OrderId, boolean all) throws BusinessException {
        Order order=null;
        try{
            OrderPo orderPo=orderPoMapper.selectByPrimaryKey(OrderId);
            if(null==orderPo){
                throw new BusinessException(ReturnNo.RESOURCE_ID_NOTEXIST, "订单id不存在");
            }
            if (all) {
                order = this.retrieveFullOrder(orderPo);
            } else {
                order=new Order(orderPo);
            }

            logger.debug("retrieveOrderByID: order = {}",  order);
        }catch (DataAccessException e){
            logger.error(e.getMessage());
            throw new BusinessException(ReturnNo.INTERNAL_SERVER_ERR,"数据库访问错误");
        }
        return order;
    }


    private Order retrieveFullOrder(OrderPo orderPo) throws DataAccessException{
        assert orderPo !=null;
        Order order=new Order(orderPo);
        List<OrderItemPo> orderItemPoList=orderItemDao.getOrderItemByOrder(orderPo.getId());
        order.addOrderItem(orderItemPoList);
        return order;
    }



}
