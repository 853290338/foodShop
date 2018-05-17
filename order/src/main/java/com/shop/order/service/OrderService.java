package com.shop.order.service;

import com.shop.order.form.OrderSaveForm;

public interface OrderService {

  /**
   * 创建订单
   *
   * @param vo see OrderSaveForm
   */
  String createOrder(OrderSaveForm vo);
}
