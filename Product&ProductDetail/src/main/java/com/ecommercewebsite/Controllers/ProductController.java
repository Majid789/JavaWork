package com.ecommercewebsite.Controllers;
import com.ecommercewebsite.Services.ProductService;
import com.ecommercewebsite.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@Controller
public class ProductController {

    @Autowired
    ProductService ProductService;
//
//    public ProductController(ProductService ProductService) {
//        this.ProductService = ProductService;
//    }

    // handler Method to handle list Product and return mode and view
    @RequestMapping("/")
    public String load(Model model)
    {
        model.addAttribute("Products",ProductService.getAllProducts());
        return "Products";
    }

    @RequestMapping("/products")
    public String listProduct(Model model)
    {
        model.addAttribute("Products",ProductService.getAllProducts());
        return "Products";
    }

    @RequestMapping("/products/new")
    public String createProductForm(Model model)
    {
        //create Product object to hold Product form data
        Product Product=new Product();
        model.addAttribute("Product",Product);
        return "create_Product";
    }

    @RequestMapping("/addproducts")
    public String saveProduct(@ModelAttribute("Product") Product Product)
    {
        ProductService.saveProduct(Product);
        return "redirect:/products";
    }

    @RequestMapping("/products/edit/{id}")
    public String editProductForm(@PathVariable Integer id,Model model)
    {
        model.addAttribute("Product",ProductService.getProductById(id));
        return "edit_Product";
    }

    @RequestMapping("/updateproducts/{id}")
    public String UpdateProduct(@PathVariable Integer id, @ModelAttribute("Product") Product Product,Model model)
    {
        //get Product from database by id
        Product existingProduct=ProductService.getProductById(id);
        existingProduct.setProductName(Product.getProductName());
        existingProduct.setProductBrand(Product.getProductBrand());
        existingProduct.setCategory(Product.getCategory());
        //save update Product object

        ProductService.updateProduct(existingProduct);
        return "redirect:/products";
    }

    @RequestMapping("/products/{id}")
    public String deleteProduct(@PathVariable Integer id)
    {
        ProductService.deleteProductbyId(id);
        return "redirect:/products";
    }

   /* @RequestMapping("/productsDetail/{id}")
    public String loadProductDetail(@PathVariable Integer id,Model model)
    {
        *//*model.addAttribute("")*//*
        return "";
    }*/
}
