package com.qacboy.sell.enums;

import lombok.Getter;

/***
 *
 * 描述：
 *
 * @author sam
 * @date 2018/9/15
 *
 */
@Getter
public enum ProductStatusEnum implements CodeEnum {
    UP(0, "在架"),
    DOWN(1, "下架");
    private Integer code;
    private String msg;

    ProductStatusEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
