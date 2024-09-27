package com.alanyu.sprintbootmall.dao;

import com.alanyu.sprintbootmall.model.Product;
import java.sql.SQLException;

public interface ProductDao {

    Product getProductById(Integer productId) ;

    Integer insertProduct(Product product);

    Product deleteProduct(Integer productId);

    Product updateProductById(Product product);

}
