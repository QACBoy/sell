package com.qacboy.sell.dal.dao;

import com.qacboy.sell.dal.model.ProductCategory;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/***
 *
 * 描述：
 *
 * @author sam
 * @date 2018/9/14
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class ProductCategoryDaoTest {

    @Autowired
    private ProductCategoryDao productCategoryDao;

    @Test
    public void findOneTest() {
        // JpaRepository 中通过 id 查询数据的新方法
        Optional<ProductCategory> productCategory = productCategoryDao.findById(1);
        log.info("productCategory: {}",productCategory.get().toString());
    }

    @Test
    @Transactional
    public void saveTest() {
        // 报错：MySQLSyntaxErrorException:Table 'sell.hibernate_sequence' doesn't exist
        // 解决方法：修改 ProductCategory 中的主键自增 注解的方式
        ProductCategory productCategory = new ProductCategory("男生最爱", 4);
        ProductCategory result = productCategoryDao.save(productCategory);
        Assert.assertNotNull(result);
    }

    @Test
    public void findByCategoryTypeInTest() {
        List<Integer> list = Arrays.asList(2,3,4);

        List<ProductCategory> result = productCategoryDao.findByCategoryTypeIn(list);
        Assert.assertNotEquals(0, result.size());
    }

    @Test
    public void updateTest() {
        // 之前的报错同保存数据的测试 saveTest()
        Optional<ProductCategory> productCategory = productCategoryDao.findById(2);
        productCategory.get().setCategoryName("男生最爱+2");
        ProductCategory result = productCategoryDao.save(productCategory.get());
    }
}