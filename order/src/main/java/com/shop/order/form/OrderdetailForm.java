package com.shop.order.form;

import javax.validation.constraints.NotNull;
import lombok.Data;

/**
 * @author denpeng
 * @create 2018-05-17 10:04
 **/
@Data
public class OrderdetailForm {

  @NotNull(message = "商品id不能为空")
  private String productId;

  @NotNull(message = "数量不能为空")
  private Integer productQuantity;

}
