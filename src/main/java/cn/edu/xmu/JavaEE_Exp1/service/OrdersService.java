package cn.edu.xmu.JavaEE_Exp1.service;

import cn.edu.xmu.JavaEE_Exp1.dao.OrdersDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import cn.edu.xmu.JavaEE_Exp1.util.BusinessException;
@Service
public class OrdersService {

    OrdersDao ordersDao;

    @Autowired
    public OrdersService(OrdersDao ordersDao){this.ordersDao=ordersDao;}

   // @Transactional(rollbackFor ={BusinessException.class})

}
