package com.shop.project.dao;

import com.shop.project.entity.ProductInfo;
import java.util.List;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductInfoDaoTest {

  @Autowired
  private ProductInfoDao dao;

  @Test
  public void findByProductStatus() {
    List<ProductInfo> productInfos = dao.findByProductStatusAndCategoryType(0, 11);
    Assert.assertTrue(productInfos.size() > 0);
  }
}