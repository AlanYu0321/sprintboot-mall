package com.alanyu.sprintbootmall.dao.impl;

import static java.sql.DriverManager.getConnection;

import com.alanyu.sprintbootmall.dao.ProductDao;
import com.alanyu.sprintbootmall.model.Product;
import com.alanyu.sprintbootmall.rowMapper.ProductRowMapper;
import java.beans.ConstructorProperties;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Types;
import java.util.Properties;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.SingleColumnRowMapper;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.jdbc.datasource.DataSourceUtils;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class ProductDaoImpl implements ProductDao {

	@Autowired
	DataSource dataSource;

	@Override
	public Product getProductById(Integer productId) {

		SimpleJdbcCall simpleJdbcCall = new SimpleJdbcCall(dataSource).withProcedureName(
				"SP_GET_PRODUCT_BY_ID").returningResultSet("product", new ProductRowMapper());

		SqlParameterSource in = new MapSqlParameterSource().addValue("i_product_id", productId);
		Map<String, Object> out = simpleJdbcCall.execute(in);
		List<Product> productList = (List<Product>) out.get("product");

//		String sql = "select product_id,product_name, category, image_url, price, stock, description, created_date, last_modified_date from product where product_id = :productId";

//		Map<String, Object> map = new HashMap<>();
//		map.put("productId", productId);

//		List<Product> productList = namedParameterJdbcTemplate.query(sql, map, new ProductRowMapper());

		return productList.stream().findAny().orElse(null);
	}

	@Override
	public Integer insertProduct(Product product) {

		SimpleJdbcCall simpleJdbcCall = new SimpleJdbcCall(dataSource).withProcedureName(
				"SP_INSERT_PRODUCT").returningResultSet("product", new ProductRowMapper());

		SqlParameterSource in = new MapSqlParameterSource().addValue("i_product_name",
						product.getProdcutName()).addValue("i_category", product.getCategory())
				.addValue("i_image_url", product.getImageUrl()).addValue("i_price", product.getPrice())
				.addValue("i_stock", product.getStock())
				.addValue("i_description",
						product.getDeiscription());
		Map<String, Object> out = simpleJdbcCall.execute(in);
		Integer productId = (Integer) out.get("o_product_id");

		return productId;

	}
}


