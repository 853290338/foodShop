package com.shop.project.service.impl;

import com.shop.project.dao.ProductCategoryDao;
import com.shop.project.dao.ProductInfoDao;
import com.shop.project.entity.ProductCategory;
import com.shop.project.entity.ProductInfo;
import com.shop.project.service.ProductCategoryService;
import com.shop.project.vo.ProductInfoVo;
import com.shop.project.vo.ProductVo;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author denpeng
 * @create 2018-05-16 14:35
 **/
@Service
public class ProductCategoryServiceImpl implements ProductCategoryService {

  private final ProductCategoryDao productCategoryDao;

  private final ProductInfoDao productInfoDao;

  @Autowired
  public ProductCategoryServiceImpl(ProductCategoryDao productCategoryDao, ProductInfoDao productInfoDao) {
    this.productCategoryDao = productCategoryDao;
    this.productInfoDao = productInfoDao;
  }


  @Override
  public List<ProductVo> list() {
    List<ProductCategory> list = productCategoryDao.findAll();
    List<ProductVo> productVos = new ArrayList<>();

    for (ProductCategory productCategory : list) {
      List<ProductInfo> infolist = productInfoDao
          .findByProductStatusAndCategoryType(0, productCategory.getCategoryType());

      if (CollectionUtils.isNotEmpty(infolist)) {
        ProductVo vo = new ProductVo();
        vo.setCategoryName(productCategory.getCategoryName());
        vo.setCategoryType(productCategory.getCategoryType());

        List<ProductInfoVo> vos = new ArrayList<>();
        for (ProductInfo productInfo : infolist) {
          ProductInfoVo productInfoVo = new ProductInfoVo();
          productInfoVo.setProductDescription(productInfo.getProductDescription());
          productInfoVo.setProductIcon(productInfo.getProductIcon());
          productInfoVo.setProductId(productInfo.getProductId());
          productInfoVo.setProductName(productInfo.getProductName());
          productInfoVo.setProductPrice(productInfo.getProductPrice());
          vos.add(productInfoVo);
        }

        vo.setProductInfoVOList(vos);
        productVos.add(vo);
      }
    }

    return productVos;
  }
}
