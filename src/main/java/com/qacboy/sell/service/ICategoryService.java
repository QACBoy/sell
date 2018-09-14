package com.qacboy.sell.service;

import com.qacboy.sell.dal.model.ProductCategory;

import java.util.List;

/***
 *
 * 描述：
 *
 * @author sam
 * @date 2018/9/14
 *
 */
public interface ICategoryService {
    ProductCategory findById(Integer categoryId);

    List<ProductCategory> findAll();

    List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList);

    ProductCategory save(ProductCategory productCategory);
}
