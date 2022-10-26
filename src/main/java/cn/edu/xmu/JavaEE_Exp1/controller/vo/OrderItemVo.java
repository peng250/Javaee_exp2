package cn.edu.xmu.JavaEE_Exp1.controller.vo;

import cn.edu.xmu.JavaEE_Exp1.dao.bo.OrderItem;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@JsonInclude
public class OrderItemVo {

    private Long skuId;

    private Long orderId;

    private String name;

    private Integer quantity;

    private Long price;

    private Long discount;

    private Long couponActId;

    private Long beShareId;

    public OrderItemVo(OrderItem orderItem) {
        this.skuId = orderItem.getGoodsSkuId();
        this.orderId = orderItem.getOrderId();
        this.name = orderItem.getName();
        this.quantity = orderItem.getQuantity();
        this.price = orderItem.getPrice();
        this.discount = orderItem.getDiscount();
        this.couponActId = orderItem.getCouponActivityId();
        this.beShareId = orderItem.getBeShareId();
    }
}
