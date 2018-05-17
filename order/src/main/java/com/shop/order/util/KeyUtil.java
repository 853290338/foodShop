package com.shop.order.util;

import java.util.Random;

/**
 * @author denpeng
 * @create 2018-05-17 10:14
 **/
public class KeyUtil {

  /**
   * 生成唯一的主键 格式: 时间+随机数
   */
  public static synchronized String genUniqueKey() {
    Random random = new Random();
    Integer number = random.nextInt(900000) + 100000;

    return System.currentTimeMillis() + String.valueOf(number);
  }

  public static void main(String [] args){
    System.out.println(KeyUtil.genUniqueKey());
  }
}
