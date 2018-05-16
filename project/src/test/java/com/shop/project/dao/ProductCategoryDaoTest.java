package com.shop.project.dao;

import com.shop.project.entity.ProductCategory;
import java.util.List;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductCategoryDaoTest {

  @Autowired
  private ProductCategoryDao dao;

  @Test
  public void findByCategoryTypeIn() {
    List<ProductCategory> list = dao.findAll();
    Assert.assertTrue(list.size() > 0);
  }
}