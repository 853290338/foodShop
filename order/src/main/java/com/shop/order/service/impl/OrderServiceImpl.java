package com.shop.order.service.impl;

import com.shop.order.dao.OrderDetailDao;
import com.shop.order.dao.OrderMasterDao;
import com.shop.order.dao.ProductInfoDao;
import com.shop.order.entity.OrderDetail;
import com.shop.order.entity.OrderMaster;
import com.shop.order.entity.ProductInfo;
import com.shop.order.enums.OrderStatusEnum;
import com.shop.order.enums.PayStatusEnum;
import com.shop.order.form.OrderSaveForm;
import com.shop.order.form.OrderdetailForm;
import com.shop.order.service.OrderService;
import com.shop.order.util.KeyUtil;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author denpeng
 * @create 2018-05-17 10:07
 **/
@Service
public class OrderServiceImpl implements OrderService {

  private final OrderMasterDao orderMasterDao;

  private final OrderDetailDao orderDetailDao;

  private final ProductInfoDao productInfoDao;

  @Autowired
  public OrderServiceImpl(OrderMasterDao orderMasterDao, OrderDetailDao orderDetailDao, ProductInfoDao productInfoDao) {
    this.orderMasterDao = orderMasterDao;
    this.orderDetailDao = orderDetailDao;
    this.productInfoDao = productInfoDao;
  }

  /**
   * 创建订单
   *
   * @param vo see OrderSaveForm
   */
  @Override
  public String createOrder(OrderSaveForm vo) {

    Date date = new Date();
    String orderId = KeyUtil.genUniqueKey();
    //商品信息
    OrderMaster master = new OrderMaster();
    master.setBuyerAddress(vo.getAddress());
    master.setBuyerName(vo.getName());
    master.setBuyerOpenid(vo.getOpenid());
    master.setBuyerPhone(vo.getPhone());
    master.setOrderId(orderId);
    master.setCreateTime(date);
    master.setUpdateTime(date);
    master.setOrderStatus(OrderStatusEnum.NEW.getCode());
    master.setPayStatus(PayStatusEnum.WAIT.getCode());

    BigDecimal price = new BigDecimal(0);//总金额
    List<OrderDetail> orderDetails = new ArrayList<>();
    List<ProductInfo> productInfos = new ArrayList<>();
    //购物车信息
    for (OrderdetailForm orderdetailForm : vo.getItem()) {
      ProductInfo productInfo = productInfoDao.findByProductId(orderdetailForm.getProductId());
      if (null == productInfo || productInfo.getProductStock() < orderdetailForm.getProductQuantity()) {
        return null;
      }

      OrderDetail detail = new OrderDetail();
      detail.setDetailId(KeyUtil.genUniqueKey());
      detail.setOrderId(orderId);
      detail.setProductIcon(productInfo.getProductIcon());
      detail.setProductName(productInfo.getProductName());
      detail.setProductId(productInfo.getProductId());
      BigDecimal productPrice = productInfo.getProductPrice();
      //总金额
      price = productPrice.multiply(new BigDecimal(orderdetailForm.getProductQuantity())).add(price);
      detail.setProductPrice(productPrice);
      detail.setProductQuantity(orderdetailForm.getProductQuantity());
      orderDetails.add(detail);

      //库存
      productInfo.setProductStock(productInfo.getProductStock() - orderdetailForm.getProductQuantity());
      productInfos.add(productInfo);
    }

    master.setOrderAmount(price);
    productInfoDao.saveAll(productInfos);
    orderDetailDao.saveAll(orderDetails);
    orderMasterDao.save(master);

    return orderId;
  }
}
