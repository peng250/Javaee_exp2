package cn.edu.xmu.jxt.exp1.controller;

import cn.edu.xmu.jxt.exp1.controller.vo.OrdersVo;
import cn.edu.xmu.jxt.exp1.dao.bo.Orders;
import cn.edu.xmu.jxt.exp1.service.OrdersService;
import cn.edu.xmu.jxt.exp1.util.BusinessException;
import cn.edu.xmu.jxt.exp1.util.ResponseUtil;
import cn.edu.xmu.jxt.exp1.util.Common;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/orders")
public class OrdersController {

    private OrdersService ordersService;

    private Logger logger = LoggerFactory.getLogger(OrdersController.class);

    @Autowired
    public OrdersController(OrdersService ordersService) {
        this.ordersService=ordersService;
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
        Orders orders=null;
        try{
            orders=ordersService.retrieveOrdersByID(id,true);
            OrdersVo ordersVo=new OrdersVo(orders);
            retObj= ResponseUtil.ok(ordersVo);
        }catch (BusinessException e){
            retObj= Common.returnWithStatus(null,e);
        }
        return retObj;
    }


}
