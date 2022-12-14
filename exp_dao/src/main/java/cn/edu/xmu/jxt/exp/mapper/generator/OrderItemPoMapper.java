package cn.edu.xmu.jxt.exp.mapper.generator;

import cn.edu.xmu.jxt.exp.mapper.generator.po.OrderItemPo;
import cn.edu.xmu.jxt.exp.mapper.generator.po.OrderItemPoExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface OrderItemPoMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table order_item
     *
     * @mbg.generated
     */
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table order_item
     *
     * @mbg.generated
     */
    int insert(OrderItemPo row);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table order_item
     *
     * @mbg.generated
     */
    int insertSelective(OrderItemPo row);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table order_item
     *
     * @mbg.generated
     */
    List<OrderItemPo> selectByExample(OrderItemPoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table order_item
     *
     * @mbg.generated
     */
    OrderItemPo selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table order_item
     *
     * @mbg.generated
     */
    int updateByExampleSelective(@Param("row") OrderItemPo row, @Param("example") OrderItemPoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table order_item
     *
     * @mbg.generated
     */
    int updateByExample(@Param("row") OrderItemPo row, @Param("example") OrderItemPoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table order_item
     *
     * @mbg.generated
     */
    int updateByPrimaryKeySelective(OrderItemPo row);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table order_item
     *
     * @mbg.generated
     */
    int updateByPrimaryKey(OrderItemPo row);
}