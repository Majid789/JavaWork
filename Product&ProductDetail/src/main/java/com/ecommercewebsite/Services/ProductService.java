package com.ecommercewebsite.Services;

import com.ecommercewebsite.entity.Product;
import com.ecommercewebsite.entity.Productdetail;

import java.util.List;

public interface ProductService {

    List<Product> getAllProducts();

    Product saveProduct(Product Product);

    Product getProductById(Integer id);

    Product updateProduct(Product Product);

    void deleteProductbyId(Integer id);

}
