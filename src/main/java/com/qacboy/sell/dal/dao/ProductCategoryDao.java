package com.qacboy.sell.dal.dao;

import com.qacboy.sell.dal.model.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/***
 *
 * 描述：
 *
 * @author sam
 * @date 2018/9/14
 *
 */
// @Repository
public interface ProductCategoryDao extends JpaRepository<ProductCategory,Integer>{

    List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList);
}