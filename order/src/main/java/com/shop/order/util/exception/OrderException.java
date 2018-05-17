package com.shop.order.util.exception;

import com.shop.order.enums.ResultEnum;

/**
 * @author denpeng
 * @create 2018-05-17 11:34
 **/
public class OrderException extends RuntimeException {

  private Integer code;

  public OrderException(Integer code, String message) {
    super(message);
    this.code = code;
  }

  public OrderException(ResultEnum resultEnum) {
    super(resultEnum.getMessage());
    this.code = resultEnum.getCode();
  }
}

