package cn.edu.xmu.jxt.exp1.service;

import cn.edu.xmu.jxt.exp1.dao.OrdersDao;
import cn.edu.xmu.jxt.exp1.dao.bo.Orders;
import cn.edu.xmu.jxt.exp1.util.BusinessException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class OrdersService {

    private Logger logger= LoggerFactory.getLogger(OrdersService.class);
    private OrdersDao ordersDao;

    @Autowired
    public OrdersService(OrdersDao ordersDao){this.ordersDao=ordersDao;}


    @Transactional(rollbackFor ={BusinessException.class})
    public Orders retrieveOrdersByID(Long id, boolean all) throws BusinessException{
        logger.debug("retrieveOrdersByID：id = {}, all = {}",id,all);
        return ordersDao.retrieveOrdersByID(id,all);
    }
}
