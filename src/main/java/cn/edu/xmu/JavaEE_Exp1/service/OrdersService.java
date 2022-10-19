package cn.edu.xmu.JavaEE_Exp1.service;

import cn.edu.xmu.JavaEE_Exp1.dao.OrderItemDao;
import cn.edu.xmu.JavaEE_Exp1.dao.OrdersDao;
import cn.edu.xmu.JavaEE_Exp1.dao.bo.Orders;
import com.mysql.cj.x.protobuf.MysqlxCrud;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import cn.edu.xmu.JavaEE_Exp1.util.BusinessException;

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
