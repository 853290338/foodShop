package com.shop.project.controller;

import com.shop.project.service.ProductCategoryService;
import com.shop.project.util.ResultVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author denpeng
 * @create 2018-05-16 14:28
 **/
@RestController
@RequestMapping("/product")
public class ProductController {

  private final ProductCategoryService productCategoryService;

  @Autowired
  public ProductController(ProductCategoryService productCategoryService) {
    this.productCategoryService = productCategoryService;
  }

  @RequestMapping(value = "list", method = RequestMethod.GET)
  public ResultVo list() {
    return ResultVo.success(productCategoryService.list());
  }
}
