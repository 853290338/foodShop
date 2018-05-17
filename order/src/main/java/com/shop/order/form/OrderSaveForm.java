package com.shop.order.form;

import java.util.List;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import lombok.Data;

/**
 * @author denpeng
 * @create 2018-05-17 10:00
 **/
@Data
public class OrderSaveForm {

  @NotBlank(message = "姓名不能为空")
  private String name;

  @NotBlank(message = "手机号不能为空")
  private String phone;

  @NotBlank(message = "地址不能为空")
  private String address;

  @NotBlank(message = "openid不能为空")
  private String openid;

  //  @NotNull(message = "购物车不能为空")
  // @Size(min = 1, message = "购物车不能为空")
  List<OrderdetailForm> item;

  @NotNull(message = "购物车不能为空")
  private String items;
}
