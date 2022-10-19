package cn.edu.xmu.JavaEE_Exp1.dao.bo;

import cn.edu.xmu.JavaEE_Exp1.mapper.generator.po.OrderItemPo;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;


@Data
@NoArgsConstructor
public class OrderItem {

    private Long id;

    private Long orderId;

    private Long goodsSkuId;

    private Integer quantity;

    private Long price;

    private Long discount;

    private String name;

    private Long couponActivityId;

    private Long beShareId;

    private LocalDateTime gmtCreate;

    private LocalDateTime gmtModified;

    public OrderItem(OrderItemPo orderItemPo) {
        assert null!=orderItemPo;
        this.id = orderItemPo.getId();
        this.orderId = orderItemPo.getOrderId();
        this.goodsSkuId = orderItemPo.getGoodsSkuId();
        this.quantity = orderItemPo.getQuantity();
        this.price = orderItemPo.getPrice();
        this.discount = orderItemPo.getDiscount();
        this.name = orderItemPo.getName();
        this.couponActivityId = orderItemPo.getCouponActivityId();
        this.beShareId = orderItemPo.getBeShareId();
        this.gmtCreate = orderItemPo.getGmtCreate();
        this.gmtModified = orderItemPo.getGmtModified();
    }
}
