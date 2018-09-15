package com.qacboy.sell.dal.dao;

import com.qacboy.sell.dal.model.ProductInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/***
 *
 * 描述：
 *
 * @author sam
 * @date 2018/9/15
 *
 */
// @Repository
public interface ProductInfoDao extends JpaRepository<ProductInfo, String> {

        List<ProductInfo> findByProductStatus(Integer productStatus);
}

