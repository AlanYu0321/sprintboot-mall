package com.alanyu.sprintbootmall.dao.impl;

import com.alanyu.sprintbootmall.dao.ProductDao;
import com.alanyu.sprintbootmall.model.Product;
import com.alanyu.sprintbootmall.rowMapper.ProductRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class ProductDaoImpl implements ProductDao {

    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Override
    public Product getProductById(Integer productId) {

        String sql = "select product_id,product_name, category, image_url, price, stock, description, created_date, last_modified_date from product where product_id = :productId";

        Map<String, Object> map = new HashMap<>();
        map.put("productId", productId);

        List<Product> productList =  namedParameterJdbcTemplate.query(sql,map,new ProductRowMapper());

        Product product = productList.stream().findAny().orElse(null);


        return product;
    }
}
