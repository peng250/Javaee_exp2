package cn.edu.xmu.jxt.exp.dao.bo;

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

}
