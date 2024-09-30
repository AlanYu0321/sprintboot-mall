package com.alanyu.sprintbootmall.controller;

import com.alanyu.sprintbootmall.model.Product;
import com.alanyu.sprintbootmall.sevice.ProductService;
import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:5173")
public class ProductContoller {

	@Autowired
	private ProductService productService;

	@PostMapping(value = "/products")
	public ResponseEntity<Map<String, Product>> getProduct(@RequestBody Product product) {

		Product responseProduct = productService.getProductById(product.getProductId());

		if (responseProduct != null) {
			Map<String, Product> response = new HashMap<>();
			response.put("reply", responseProduct);
			return ResponseEntity.ok(response);
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
	}

	@PostMapping(value = "/insertProducts")
	public ResponseEntity<Product> insertProduct(@RequestBody Product product) {

		Product responseProduct = productService.insertProduct(product);

		if (responseProduct != null) {
			return ResponseEntity.status(HttpStatus.OK).body(responseProduct);
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
	}

	@PostMapping(value = "/deleteProductById")
	public ResponseEntity<String> deleteProductById(@RequestBody Product product) {

		Product responseProduct = productService.deleteProductById(product.getProductId());

		if (responseProduct != null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		} else {
			return ResponseEntity.status(HttpStatus.OK).body("Product has been delete");
		}

	}

	@PostMapping(value = "/updateProductById")
	public ResponseEntity<Product> updateProductById(@RequestBody Product product) {

		Product responseProduct = productService.updateProductById(product);

		if (responseProduct != null) {
			return ResponseEntity.status(HttpStatus.OK).body(responseProduct);
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}

	}

	@PostMapping(value = "/helloWorld")
	public ResponseEntity<Map<String, String>> helloWorld(
			@RequestBody Map<String, String> requestData) {

		// 從請求中獲取資料
		String clientMessage = requestData.get("message");

		Map<String, String> response = new HashMap<>();
		response.put("reply", "Hello, Vue!" + clientMessage);
		return ResponseEntity.ok(response);
	}
}
