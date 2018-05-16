package com.shop.project.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import lombok.Data;

/**
 * @author denpeng
 * @create 2018-05-16 14:37
 **/
@Data
public class ProductVo {

  @JsonProperty("name")
  private String categoryName;

  @JsonProperty("type")
  private Integer categoryType;

  @JsonProperty("foods")
  List<ProductInfoVo> productInfoVOList;

}
