package com.alanyu.sprintbootmall.sevice;

import com.alanyu.sprintbootmall.model.Product;

public interface ProductService {

    Product getProductById(Integer productId) ;
    Product insertProduct(Product product) ;
    Product deleteProductById(Product product);
}
