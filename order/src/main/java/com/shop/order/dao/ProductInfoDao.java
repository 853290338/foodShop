package com.shop.order.dao;

import com.shop.order.entity.ProductInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductInfoDao extends JpaRepository<ProductInfo, String> {

  ProductInfo findByProductId(String productId);
}
