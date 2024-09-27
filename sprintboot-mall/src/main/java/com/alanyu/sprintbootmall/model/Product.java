package com.alanyu.sprintbootmall.model;

import com.alanyu.sprintbootmall.Enum.ProductCategory;

import java.util.Date;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Product {

	private Integer productId;
	private String prodcutName;
	private ProductCategory category;
	private String imageUrl;
	private Integer price;
	private Integer stock;
	private String deiscription;
	private Date createdDate;
	private Date lastmodifiedDate;

}
