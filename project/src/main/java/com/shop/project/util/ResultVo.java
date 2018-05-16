package com.shop.project.util;

import lombok.Data;

/**
 * 返回数据
 *
 * @author denpeng
 * @create 2018-05-16 14:17
 **/
@Data
public class ResultVo {

  private Integer code;

  private String msg;

  private Object data;

  public static ResultVo success(Object data) {
    ResultVo vo = new ResultVo();
    vo.setCode(0);
    vo.setData(data);
    vo.setMsg("成功");
    return vo;
  }


}
