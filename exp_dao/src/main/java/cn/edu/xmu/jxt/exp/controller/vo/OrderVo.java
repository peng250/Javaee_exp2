package cn.edu.xmu.jxt.exp.controller.vo;

import cn.edu.xmu.jxt.exp.dao.bo.Order;
import cn.edu.xmu.jxt.exp.dao.bo.OrderItem;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;


/**
 * 订单视图对象
 *
 * @author Dasong Lu
 */
@Data
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class OrderVo {

    private List<OrderItemVo> orderItems = new ArrayList<>();

    private String consignee;

    private Long regionId;

    private String address;

    private String mobile;

    private String message;

    private Long couponId;

    private Long presaleId;

    private Long grouponId;

    public Order createBo() {
        Order order = new Order();
        order.setConsignee(this.consignee);
        order.setRegionId(this.regionId);
        order.setAddress(this.address);
        order.setMobile(this.mobile);
        order.setMessage(this.message);
        order.setCouponId(this.couponId);
        order.setPresaleId(this.presaleId);
        order.setGrouponId(this.grouponId);
        List<OrderItem> orderItemList = new ArrayList<>();
        this.orderItems.forEach(orderItemVo -> orderItemList.add(orderItemVo.createBo()));
        order.setOrderItemList(orderItemList);
        return order;
    }

    public OrderVo(Order order) {
        this.consignee = order.getConsignee();
        this.regionId = order.getRegionId();
        this.address = order.getAddress();
        this.mobile = order.getMobile();
        this.message = order.getMessage();
        this.couponId = order.getCouponId();
        this.presaleId = order.getPresaleId();
        this.grouponId = order.getGrouponId();
        order.getOrderItemList().forEach(orderItem -> this.orderItems.add(new OrderItemVo(orderItem)));
    }
}
