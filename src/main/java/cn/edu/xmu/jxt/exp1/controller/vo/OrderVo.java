package cn.edu.xmu.jxt.exp1.controller.vo;

import cn.edu.xmu.jxt.exp1.dao.bo.OrderItem;
import cn.edu.xmu.jxt.exp1.dao.bo.Order;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@JsonInclude
public class OrderVo {

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

    public OrderVo(Order order) {
        this.id = order.getId();
        this.orderSn = order.getOrderSn();
        this.pid = order.getPid();
        this.orderType = order.getOrderType();
        this.state = order.getState();
        this.gmtCreate = order.getGmtCreate();
        this.gmtModified = order.getGmtModified();
        this.confirmTime = order.getConfirmTime();
        this.originPrice = order.getOriginPrice();
        this.discountPrice = order.getDiscountPrice();
        this.freightPrice = order.getFreightPrice();
        this.rebateNum = order.getRebateNum();
        this.message = order.getMessage();
        this.regionId = order.getRegionId();
        this.address = order.getAddress();
        this.mobile = order.getMobile();
        this.consignee = order.getConsignee();
        this.couponId = order.getCouponId();
        this.grouponId = order.getGrouponId();
        this.presaleId = order.getPresaleId();
        this.shipmentSn = order.getShipmentSn();
        if(order.getOrderItemList().size() > 0){
            List<OrderItemVo> orderItemVos=new ArrayList<>(order.getOrderItemList().size());
            for(OrderItem orderItem: order.getOrderItemList()){
                OrderItemVo orderItemVo=new OrderItemVo(orderItem);
                orderItemVos.add(orderItemVo);
            }
            this.orderItemVoList=orderItemVos;
        }
    }


}
