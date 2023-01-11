package com.ecommercewebsite.Services.ProductServiceImpl;

import com.ecommercewebsite.Services.ProductService;
import com.ecommercewebsite.entity.Product;
import com.ecommercewebsite.repository.ProductRepository;
import com.ecommercewebsite.repository.ProductdetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductRepository productRepository;

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public  Product saveProduct(Product Product)
    {
        return productRepository.save(Product);
    }

    @Override
    public Product getProductById(Integer id) {
        return productRepository.findById(id).get();
    }

    @Override
    public Product updateProduct(Product Product) {
        return productRepository.save(Product);
    }

    @Override
    public void deleteProductbyId(Integer id) {
        productRepository.deleteById(id);
    }
}
