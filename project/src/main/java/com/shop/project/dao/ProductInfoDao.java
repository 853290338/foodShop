package com.shop.project.dao;

import com.shop.project.entity.ProductInfo;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductInfoDao extends JpaRepository<ProductInfo, String> {

  List<ProductInfo> findByProductStatusAndCategoryType(Integer status, Integer categoryType);
}
