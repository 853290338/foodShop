package com.shop.order.controller;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.shop.order.form.OrderSaveForm;
import com.shop.order.form.OrderdetailForm;
import com.shop.order.service.OrderService;
import com.shop.order.VO.ResultVo;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author denpeng
 * @create 2018-05-17 10:05
 **/
@RestController
@RequestMapping("order")
public class OrderController {

  private final OrderService orderService;

  @Autowired
  public OrderController(OrderService orderService) {
    this.orderService = orderService;
  }

  @SuppressWarnings("unchecked")
  @RequestMapping(value = "create", method = RequestMethod.POST)
  public ResultVo create(OrderSaveForm vo) throws IOException {

//    ObjectMapper mapper = new ObjectMapper();
//    JavaType javaType = mapper.getTypeFactory().constructParametricType(ArrayList.class, OrderdetailForm.class);
//    List<OrderdetailForm> forms = (List<OrderdetailForm>) mapper.readValue(vo.getItems(), javaType);
    Gson gson = new Gson();
    List<OrderdetailForm> forms = new ArrayList<>();
    forms = gson.fromJson(vo.getItems(), new TypeToken<List<OrderdetailForm>>() {
    }.getType());

    vo.setItem(forms);
    String orderid = orderService.createOrder(vo);
    Map<String, String> map = new HashMap<>();
    map.put("orderId", orderid);
    return ResultVo.success(map);
  }
}
