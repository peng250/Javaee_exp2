package cn.edu.xmu.JavaEE_Exp1.dao.bo;

import cn.edu.xmu.JavaEE_Exp1.mapper.generator.po.OrderItemPo;
import cn.edu.xmu.JavaEE_Exp1.mapper.generator.po.OrdersPo;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
public class Orders {

    private List<OrderItem> orderItemList=new ArrayList<>();

    private Long id;

    private Long customerId;

    private Long shopId;

    private String orderSn;

    private Long pid;

    private String consignee;

    private Long regionId;

    private String address;

    private String mobile;

    private String message;

    private Byte orderType;

    private Long freightPrice;

    private Long couponId;

    private Long couponActivityId;

    private Long discountPrice;

    private Long originPrice;

    private Long presaleId;

    private Long grouponDiscount;

    private Integer rebateNum;

    private LocalDateTime confirmTime;

    private String shipmentSn;

    private Byte state;

    private Byte substate;

    private Byte beDeleted;

    private LocalDateTime gmtCreate;

    private LocalDateTime gmtModified;

    private Long grouponId;

    public Orders(OrdersPo ordersPo) {
        assert null !=ordersPo;
        this.id = ordersPo.getId();
        this.customerId = ordersPo.getCustomerId();
        this.shopId = ordersPo.getShopId();
        this.orderSn = ordersPo.getOrderSn();
        this.pid = ordersPo.getPid();
        this.consignee = ordersPo.getConsignee();
        this.regionId = ordersPo.getRegionId();
        this.address = ordersPo.getAddress();
        this.mobile = ordersPo.getMobile();
        this.message = ordersPo.getMessage();
        this.orderType = ordersPo.getOrderType();
        this.freightPrice = ordersPo.getFreightPrice();
        this.couponId = ordersPo.getCouponId();
        this.couponActivityId = ordersPo.getCouponActivityId();
        this.discountPrice = ordersPo.getDiscountPrice();
        this.originPrice = ordersPo.getOriginPrice();
        this.presaleId = ordersPo.getPresaleId();
        this.grouponDiscount = ordersPo.getGrouponDiscount();
        this.rebateNum = ordersPo.getRebateNum();
        this.confirmTime = ordersPo.getConfirmTime();
        this.shipmentSn = ordersPo.getShipmentSn();
        this.state = ordersPo.getState();
        this.substate = ordersPo.getSubstate();
        this.beDeleted = ordersPo.getBeDeleted();
        this.gmtCreate = ordersPo.getGmtCreate();
        this.gmtModified = ordersPo.getGmtModified();
        this.grouponId = ordersPo.getGrouponId();
    }

    public void addOrderItem(List<OrderItemPo> poList) {
        for(OrderItemPo orderItemPo:poList) {
            this.orderItemList.add(new OrderItem(orderItemPo));
        }
    }





}
