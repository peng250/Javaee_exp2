package cn.edu.xmu.jxt.exp1.dao;

import cn.edu.xmu.jxt.exp1.dao.bo.Orders;
import cn.edu.xmu.jxt.exp1.mapper.generator.OrdersPoMapper;
import cn.edu.xmu.jxt.exp1.mapper.generator.po.OrderItemPo;
import cn.edu.xmu.jxt.exp1.mapper.generator.po.OrdersPo;
import cn.edu.xmu.jxt.exp1.util.BusinessException;
import cn.edu.xmu.jxt.exp1.util.ReturnNo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class OrdersDao {

    private Logger logger= LoggerFactory.getLogger(OrdersDao.class);

    private OrdersPoMapper ordersPoMapper;

    private OrderItemDao orderItemDao;


    @Autowired
    public OrdersDao(OrdersPoMapper ordersPoMapper, OrderItemDao orderItemDao) {
        this.ordersPoMapper = ordersPoMapper;
        this.orderItemDao = orderItemDao;
    }

    public Orders retrieveOrdersByID(Long OrdersId, boolean all) throws BusinessException {
        Orders orders=null;
        try{
            OrdersPo ordersPo=ordersPoMapper.selectByPrimaryKey(OrdersId);
            if(null==ordersPo){
                throw new BusinessException(ReturnNo.RESOURCE_ID_NOTEXIST, "订单id不存在");
            }
            if (all) {
                orders = this.retrieveFullOrders(ordersPo);
            } else {
                orders=new Orders(ordersPo);
            }

            logger.debug("retrieveOrdersByID: orders = {}",  orders);
        }catch (DataAccessException e){
            logger.error(e.getMessage());
            throw new BusinessException(ReturnNo.INTERNAL_SERVER_ERR,"数据库访问错误");
        }
        return orders;
    }


    private Orders retrieveFullOrders(OrdersPo ordersPo) throws DataAccessException{
        assert ordersPo !=null;
        Orders orders=new Orders(ordersPo);
        List<OrderItemPo> orderItemPoList=orderItemDao.getOrderItemByOrders(ordersPo.getId());
        orders.addOrderItem(orderItemPoList);
        return orders;
    }



}
