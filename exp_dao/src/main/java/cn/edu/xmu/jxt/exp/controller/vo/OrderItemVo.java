package cn.edu.xmu.jxt.exp.controller.vo;

import cn.edu.xmu.jxt.exp.dao.bo.OrderItem;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 订单明细视图对象
 *
 * @author Dasong Lu
 */
@Data
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class OrderItemVo {

    private Long skuId;

    private Integer quantity;

    private Long couponActId;

    public OrderItemVo(OrderItem orderItem) {
        this.skuId = orderItem.getGoodsSkuId();
        this.quantity = orderItem.getQuantity();
        this.couponActId = orderItem.getCouponActivityId();
    }

    public OrderItem createBo() {
        OrderItem orderItem = new OrderItem();
        orderItem.setGoodsSkuId(this.skuId);
        orderItem.setQuantity(this.quantity);
        orderItem.setCouponActivityId(this.couponActId);
        return orderItem;
    }
}
