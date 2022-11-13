package cn.edu.xmu.jxt.exp.dao.bo;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static cn.edu.xmu.jxt.exp.util.Common.cloneObj;

@Data
@NoArgsConstructor
public class Order {

    private List<OrderItem> orderItems;

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


}
