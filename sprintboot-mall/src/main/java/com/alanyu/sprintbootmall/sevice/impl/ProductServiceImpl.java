package com.alanyu.sprintbootmall.sevice.impl;

import com.alanyu.sprintbootmall.dao.ProductDao;
import com.alanyu.sprintbootmall.model.Product;
import com.alanyu.sprintbootmall.sevice.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductDao productDao;
    @Override
    public Product getProductById(Integer productId) {
        return productDao.getProductById(productId);
    }
}
