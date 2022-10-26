package cn.edu.xmu.jxt.exp1.controller;

import cn.edu.xmu.jxt.exp1.controller.vo.OrderVo;
import cn.edu.xmu.jxt.exp1.dao.bo.Order;
import cn.edu.xmu.jxt.exp1.service.OrderService;
import cn.edu.xmu.jxt.exp1.util.BusinessException;
import cn.edu.xmu.jxt.exp1.util.ResponseUtil;
import cn.edu.xmu.jxt.exp1.util.Common;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/orders")
public class OrderController {

    private OrderService orderService;

    private Logger logger = LoggerFactory.getLogger(OrderController.class);

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService=orderService;
    }

    /**
     * 查询订单完整信息
     * @param id
     * @return
     */
    @GetMapping("{id}")
    public Object getOrderById(@PathVariable("id")long id) {
        logger.debug("getOrderById: id={}",id);
        Object retObj=null;
        Order order=null;
        try{
            order=orderService.retrieveOrderByID(id,true);
            OrderVo orderVo=new OrderVo(order);
            retObj= ResponseUtil.ok(orderVo);
        }catch (BusinessException e){
            retObj= Common.returnWithStatus(null,e);
        }
        return retObj;
    }


}