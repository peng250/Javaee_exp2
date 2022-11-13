package cn.edu.xmu.jxt.exp.mapper;

import cn.edu.xmu.jxt.exp.dao.bo.Order;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface OrderMapper {
    Order selectByPrimaryKey(Long id);
}