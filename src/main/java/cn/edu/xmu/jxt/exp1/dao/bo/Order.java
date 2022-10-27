package cn.edu.xmu.jxt.exp1.dao.bo;

import cn.edu.xmu.jxt.exp1.mapper.generator.po.OrderItemPo;
import cn.edu.xmu.jxt.exp1.mapper.generator.po.OrderPo;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
public class Order {

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

    public Order(OrderPo orderPo) {
        assert null !=orderPo;
        this.id = orderPo.getId();
        this.customerId = orderPo.getCustomerId();
        this.shopId = orderPo.getShopId();
        this.orderSn = orderPo.getOrderSn();
        this.pid = orderPo.getPid();
        this.consignee = orderPo.getConsignee();
        this.regionId = orderPo.getRegionId();
        this.address = orderPo.getAddress();
        this.mobile = orderPo.getMobile();
        this.message = orderPo.getMessage();
        this.orderType = orderPo.getOrderType();
        this.freightPrice = orderPo.getFreightPrice();
        this.couponId = orderPo.getCouponId();
        this.couponActivityId = orderPo.getCouponActivityId();
        this.discountPrice = orderPo.getDiscountPrice();
        this.originPrice = orderPo.getOriginPrice();
        this.presaleId = orderPo.getPresaleId();
        this.grouponDiscount = orderPo.getGrouponDiscount();
        this.rebateNum = orderPo.getRebateNum();
        this.confirmTime = orderPo.getConfirmTime();
        this.shipmentSn = orderPo.getShipmentSn();
        this.state = orderPo.getState();
        this.substate = orderPo.getSubstate();
        this.beDeleted = orderPo.getBeDeleted();
        this.gmtCreate = orderPo.getGmtCreate();
        this.gmtModified = orderPo.getGmtModified();
        this.grouponId = orderPo.getGrouponId();
    }

    public void addOrderItem(List<OrderItemPo> poList) {
        for(OrderItemPo orderItemPo:poList) {
            this.orderItemList.add(new OrderItem(orderItemPo));
        }
    }

    /**
     * 用订单 bo 创建 po
     *
     * @return OrderPo
     */
    public OrderPo createPo() {
        OrderPo orderPo = new OrderPo();
        orderPo.setCustomerId(this.customerId);
        orderPo.setShopId(this.shopId);
        orderPo.setOrderSn(this.orderSn);
        orderPo.setPid(this.pid);
        orderPo.setConsignee(this.consignee);
        orderPo.setRegionId(this.regionId);
        orderPo.setAddress(this.address);
        orderPo.setMobile(this.mobile);
        orderPo.setMessage(this.message);
        orderPo.setOrderType(this.orderType);
        orderPo.setFreightPrice(this.freightPrice);
        orderPo.setCouponId(this.couponId);
        orderPo.setCouponActivityId(this.couponActivityId);
        orderPo.setDiscountPrice(this.discountPrice);
        orderPo.setOriginPrice(this.originPrice);
        orderPo.setPresaleId(this.presaleId);
        orderPo.setGrouponDiscount(this.grouponDiscount);
        orderPo.setRebateNum(this.rebateNum);
        orderPo.setConfirmTime(this.confirmTime);
        orderPo.setShipmentSn(this.shipmentSn);
        orderPo.setState(this.state);
        orderPo.setSubstate(this.substate);
        orderPo.setBeDeleted(this.beDeleted);
        orderPo.setGmtCreate(this.gmtCreate);
        orderPo.setGmtModified(this.gmtModified);
        orderPo.setGrouponId(this.grouponId);
        return orderPo;
    }
}
