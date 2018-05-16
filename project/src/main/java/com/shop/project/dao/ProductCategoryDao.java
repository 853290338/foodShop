package com.shop.project.dao;

import com.shop.project.entity.ProductCategory;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductCategoryDao extends JpaRepository<ProductCategory, Integer> {

  List<ProductCategory> findAll();
}
