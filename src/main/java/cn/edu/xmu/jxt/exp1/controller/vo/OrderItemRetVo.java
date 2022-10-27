package cn.edu.xmu.jxt.exp1.controller.vo;

import cn.edu.xmu.jxt.exp1.dao.bo.OrderItem;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@JsonInclude
public class OrderItemRetVo {

    private Long skuId;

    private Long orderId;

    private String name;

    private Integer quantity;

    private Long price;

    private Long discount;

    private Long couponActId;

    private Long beShareId;

    public OrderItemRetVo(OrderItem orderItem) {
        this.skuId = orderItem.getGoodsSkuId();
        this.orderId = orderItem.getOrderId();
        this.name = orderItem.getName();
        this.quantity = orderItem.getQuantity();
        this.price = orderItem.getPrice();
        this.discount = orderItem.getDiscount();
        this.couponActId = orderItem.getCouponActivityId();
        this.beShareId = orderItem.getBeShareId();
    }

    public OrderItem createBo() {
        OrderItem orderItem = new OrderItem();
        orderItem.setGoodsSkuId(this.skuId);
        orderItem.setOrderId(this.orderId);
        orderItem.setName(this.name);
        orderItem.setQuantity(this.quantity);
        orderItem.setPrice(this.price);
        orderItem.setDiscount(this.discount);
        orderItem.setCouponActivityId(this.couponActId);
        orderItem.setBeShareId(this.beShareId);
        return orderItem;
    }
}
