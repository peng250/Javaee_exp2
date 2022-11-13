package cn.edu.xmu.jxt.exp.dao;

import cn.edu.xmu.jxt.exp.mapper.generator.OrderItemPoMapper;
import cn.edu.xmu.jxt.exp.mapper.generator.po.OrderItemPo;
import cn.edu.xmu.jxt.exp.mapper.generator.po.OrderItemPoExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class OrderItemDao {

    private OrderItemPoMapper orderItemPoMapper;

    @Autowired
    public OrderItemDao(OrderItemPoMapper orderItemPoMapper) {
        this.orderItemPoMapper = orderItemPoMapper;
    }

    public List<OrderItemPo> getOrderItemByOrder(Long orderId){
        OrderItemPoExample orderItemPoExample=new OrderItemPoExample();
        OrderItemPoExample.Criteria criteria=orderItemPoExample.createCriteria();
        criteria.andOrderIdEqualTo(orderId);
        List<OrderItemPo> orderItemPoList=orderItemPoMapper.selectByExample(orderItemPoExample);
        return  orderItemPoList;
    }

    /**
     * 创建订单项
     *
     * @param orderItemPo 订单项 po
     */
    public void createOrderItem(OrderItemPo orderItemPo){
        orderItemPoMapper.insert(orderItemPo);
    }
}
