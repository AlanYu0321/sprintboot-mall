package com.alanyu.sprintbootmall.model;

import com.alanyu.sprintbootmall.Enum.ProductCategory;

import java.util.Date;

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

   public Integer getProductId() {
      return productId;
   }

   public void setProductId(Integer productId) {
      this.productId = productId;
   }

   public String getProdcutName() {
      return prodcutName;
   }

   public void setProdcutName(String prodcutName) {
      this.prodcutName = prodcutName;
   }

   public ProductCategory getCategory() {
      return category;
   }

   public void setCategory(ProductCategory category) {
      this.category = category;
   }

   public String getImageUrl() {
      return imageUrl;
   }

   public void setImageUrl(String imageUrl) {
      this.imageUrl = imageUrl;
   }

   public Integer getPrice() {
      return price;
   }

   public void setPrice(Integer price) {
      this.price = price;
   }

   public Integer getStock() {
      return stock;
   }

   public void setStock(Integer stock) {
      this.stock = stock;
   }

   public String getDeiscription() {
      return deiscription;
   }

   public void setDeiscription(String deiscription) {
      this.deiscription = deiscription;
   }

   public Date getCreatedDate() {
      return createdDate;
   }

   public void setCreatedDate(Date createdDate) {
      this.createdDate = createdDate;
   }

   public Date getLastmodifiedDate() {
      return lastmodifiedDate;
   }

   public void setLastmodifiedDate(Date lastmodifiedDate) {
      this.lastmodifiedDate = lastmodifiedDate;
   }
}
