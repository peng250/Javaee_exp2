package cn.edu.xmu.jxt.exp1.service;

import cn.edu.xmu.jxt.exp1.dao.OrderDao;
import cn.edu.xmu.jxt.exp1.dao.bo.Order;
import cn.edu.xmu.jxt.exp1.util.BusinessException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class OrderService {

    private Logger logger= LoggerFactory.getLogger(OrderService.class);
    private OrderDao orderDao;

    @Autowired
    public OrderService(OrderDao orderDao){this.orderDao=orderDao;}


    @Transactional(rollbackFor ={BusinessException.class})
    public Order retrieveOrderByID(Long id, boolean all) throws BusinessException{
        logger.debug("retrieveOrderByID：id = {}, all = {}",id,all);
        return orderDao.retrieveOrderByID(id,all);
    }
}
