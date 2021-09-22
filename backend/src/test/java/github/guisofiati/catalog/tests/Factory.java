package github.guisofiati.catalog.tests;

import java.time.Instant;

import github.guisofiati.catalog.dto.ProductDTO;
import github.guisofiati.catalog.entities.Category;
import github.guisofiati.catalog.entities.Product;

public class Factory {
	
	public static Product createProduct() {
		Product product = new Product(1L, "Phone", "Good phone", 800.0, "https://img.com/img.png", Instant.parse("2021-09-09T03:00:00Z"));
		product.getCategories().add(new Category(2L, "Electronics"));
		return product;
	}
	
	public static ProductDTO createProductDTO() {
		Product product = createProduct();
		return new ProductDTO(product, product.getCategories());
	}
}