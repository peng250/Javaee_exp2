package cn.edu.xmu.jxt.exp1.controller.vo;

import cn.edu.xmu.jxt.exp1.dao.bo.OrderItem;
import cn.edu.xmu.jxt.exp1.dao.bo.Orders;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@JsonInclude
public class OrdersVo {

    private Long id;

    private String orderSn;

    private Long pid;

    private Byte orderType;

    private Byte state;

    private LocalDateTime gmtCreate;

    private LocalDateTime gmtModified;

    private LocalDateTime confirmTime;

    private Long originPrice;

    private Long discountPrice;

    private Long freightPrice;

    private Integer rebateNum;

    private String message;

    private Long regionId;

    private String address;

    private String mobile;

    private String consignee;

    private Long couponId;

    private Long grouponId;

    private Long presaleId;

    private String shipmentSn;

    private List<OrderItemVo> orderItemVoList=new ArrayList<>();

    public OrdersVo(Orders orders) {
        this.id = orders.getId();
        this.orderSn = orders.getOrderSn();
        this.pid = orders.getPid();
        this.orderType = orders.getOrderType();
        this.state = orders.getState();
        this.gmtCreate = orders.getGmtCreate();
        this.gmtModified = orders.getGmtModified();
        this.confirmTime = orders.getConfirmTime();
        this.originPrice = orders.getOriginPrice();
        this.discountPrice = orders.getDiscountPrice();
        this.freightPrice = orders.getFreightPrice();
        this.rebateNum = orders.getRebateNum();
        this.message = orders.getMessage();
        this.regionId = orders.getRegionId();
        this.address = orders.getAddress();
        this.mobile = orders.getMobile();
        this.consignee = orders.getConsignee();
        this.couponId = orders.getCouponId();
        this.grouponId = orders.getGrouponId();
        this.presaleId = orders.getPresaleId();
        this.shipmentSn = orders.getShipmentSn();
        if(orders.getOrderItemList().size() > 0){
            List<OrderItemVo> orderItemVos=new ArrayList<>(orders.getOrderItemList().size());
            for(OrderItem orderItem: orders.getOrderItemList()){
                OrderItemVo orderItemVo=new OrderItemVo(orderItem);
                orderItemVos.add(orderItemVo);
            }
            this.orderItemVoList=orderItemVos;
        }
    }


}
