package com.qacboy.sell.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/***
 *
 * 描述：
 *      http 请求返回的最外层对象
 *
 * @author sam
 * @date 2018/9/15
 *
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResultVO<T> {

    /**
     * 错误码
     */
    private Integer code;

    /**
     * 提示信息
     */
    private String msg;

    /**
     * 具体的数据内容
     */
    private T data;
}
