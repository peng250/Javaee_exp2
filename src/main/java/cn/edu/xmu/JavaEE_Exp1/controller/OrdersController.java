package cn.edu.xmu.JavaEE_Exp1.controller;

import cn.edu.xmu.JavaEE_Exp1.service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/orders")
public class OrdersController {

    OrdersService ordersService;

    @Autowired
    public OrdersController(OrdersService ordersService)
    {
        this.ordersService=ordersService;
    }

    /**
     * 查询订单完整信息
     * @param id
     * @return
     */
    @GetMapping("{id}")
    public void getOrderById(@PathVariable("id")long id)
    {

    }
}
