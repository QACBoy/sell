package com.qacboy.sell.controller;

import com.qacboy.sell.dal.model.ProductCategory;
import com.qacboy.sell.dal.model.ProductInfo;
import com.qacboy.sell.service.ICategoryService;
import com.qacboy.sell.service.IProductService;
import com.qacboy.sell.utils.ResultVOUtil;
import com.qacboy.sell.vo.ResultVO;
import com.qacboy.sell.vo.ProductInfoVO;
import com.qacboy.sell.vo.ProductVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/***
 *
 * 描述：
 *
 * @author sam
 * @date 2018/9/15
 *
 */
@RestController
@RequestMapping("/buyer/product")
public class BuyerProductController {

    @Autowired
    private IProductService productService;

    @Autowired
    private ICategoryService categoryService;

    /**
     * URL: http://127.0.0.1:8080/sell/buyer/product/list
     *
     * @return
     */
    @GetMapping("/list")
    public ResultVO list() {

        // 查询所有的上架商品
        List<ProductInfo> productInfoList = productService.findUpAll();

/*        // 查询类目（一次性查询）
        List<Integer> categoryTypeList = new ArrayList<>();
        // 使用传统方法
        for (ProductInfo productInfo:productInfoList){
            categoryTypeList.add(productInfo.getCategoryType());
        }*/
        // 使用 java8 的 lambda 表达式
        List<Integer> categoryTypeList = productInfoList.stream()
                .map(e -> e.getCategoryType())
                .collect(Collectors.toList());
        List<ProductCategory> productCategoryList = categoryService.findByCategoryTypeIn(categoryTypeList);
        // 数据拼装
        List<ProductVO>productVOlist=new ArrayList<>();
        for (ProductCategory productCategory : productCategoryList) {
            ProductVO productVO = new ProductVO();
            productVO.setProductName(productCategory.getCategoryName());
            productVO.setCategoryType(productCategory.getCategoryType());

            List<ProductInfoVO> productInfoVOList=new ArrayList<>();
            for (ProductInfo productInfo : productInfoList) {
                // 先判断他们的类型是否一致，一致在添加到同一个list里面
                if (productInfo.getCategoryType().equals(productCategory.getCategoryType())) {
                    ProductInfoVO productInfoVO = new ProductInfoVO();
                    BeanUtils.copyProperties(productInfo, productInfoVO);
                    productInfoVOList.add(productInfoVO);
                }
            }
            productVO.setProductInfoVOList(productInfoVOList);
            productVOlist.add(productVO);
        }

        // ResultVO resultVO = new ResultVO();
        // ProductVO productVO = new ProductVO();
        // ProductInfoVO productInfoVO = new ProductInfoVO();
        // resultVO.setCode(0);
        // resultVO.setMsg("成功");
        // resultVO.setData(productVOlist);
        // productVO.setProductInfoVOList(Arrays.asList(productInfoVO));
        // resultVO.setData(Arrays.asList(productVO));
        return ResultVOUtil.success(productVOlist );
    }
}
