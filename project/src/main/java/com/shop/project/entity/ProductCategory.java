package com.shop.project.entity;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import lombok.Data;

/**
 * @author denpeng
 * @create 2018-05-16 14:08
 **/
@Data
@Entity
public class ProductCategory {

  @Id
  @GeneratedValue
  private Integer categoryId;

  /**
   * 类目名字.
   */
  private String categoryName;

  /**
   * 类目编号.
   */
  private Integer categoryType;

  private Date createTime;

  private Date updateTime;
}