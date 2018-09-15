package com.qacboy.sell.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/***
 *
 * 描述：
 *
 * @author sam
 * @date 2018/9/15
 *
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductVO {

    @JsonProperty("name")
    private String productName;

    @JsonProperty("type")
    private Integer categoryType;

    @JsonProperty("foods")
    private List<ProductInfoVO> productInfoVOList;
}
