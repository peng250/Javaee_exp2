package cn.edu.xmu.jxt.exp.controller;

import cn.edu.xmu.jxt.exp.controller.vo.OrderRetVo;
import cn.edu.xmu.jxt.exp.dao.bo.Order;
import cn.edu.xmu.jxt.exp.service.OrderService;
import cn.edu.xmu.jxt.exp.util.BusinessException;
import cn.edu.xmu.jxt.exp.util.ResponseUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import static cn.edu.xmu.jxt.exp.util.Common.cloneObj;
import static cn.edu.xmu.jxt.exp.util.Common.returnWithStatus;

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
            order=orderService.retrieveOrderByID(id);
            OrderRetVo orderVo=new OrderRetVo(order);
            retObj= ResponseUtil.ok(orderVo);
        }catch (BusinessException e){
            retObj= returnWithStatus(null,e);
        }
        return retObj;
    }
}
