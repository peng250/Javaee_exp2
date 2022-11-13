package cn.edu.xmu.jxt.exp.service;

import cn.edu.xmu.jxt.exp.dao.OrderDao;
import cn.edu.xmu.jxt.exp.dao.bo.Order;
import cn.edu.xmu.jxt.exp.util.BusinessException;
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
    public Order retrieveOrderByID(Long id) throws BusinessException{
        logger.debug("retrieveOrderByID：id = {}",id);
        return orderDao.retrieveOrderByID(id);
    }

}
