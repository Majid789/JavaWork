package com.ecommercewebsite.Controllers;

import com.ecommercewebsite.Services.ProductDetailService;
import com.ecommercewebsite.Services.ProductService;
import com.ecommercewebsite.entity.Product;
import com.ecommercewebsite.entity.Productdetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/productdetail")
public class ProductDetailController {

    @Autowired
    ProductService productService;

    @Autowired
    ProductDetailService productDetailService;

    @RequestMapping("/productsDetail/{id}")
    public String listProductDetail(@PathVariable Integer id, Model model)
    {
        Product existingproduct=productService.getProductById(id);
        model.addAttribute("ProductsDetail",productDetailService.getAllProductDetailByProductId(id));
        model.addAttribute("Product",existingproduct);
        return "ProductsDetails";
    }

  /*  @RequestMapping("/productsDetail")
    public String listProductDetail(@PathVariable Integer id, Model model)
    {
        Product existingproduct=productService.getProductById(id);
        model.addAttribute("ProductsDetail",productDetailService.getAllProductDetailByProductId(id));
        model.addAttribute("Product",existingproduct);
        return "ProductsDetails";
    }*/

    @RequestMapping("/productsDetail/new/{id}")
    public String createProductForm(@PathVariable Integer id, Model model)
    {
        //create Product object to hold Product form data
        Productdetail Productdetail=new Productdetail();
        Product existingProduct=productService.getProductById(id);
        //Productdetail.setProduct(existingProduct);
        model.addAttribute("Productdetail",Productdetail);
        model.addAttribute("Product",existingProduct);
        return "create_Productdetail";
    }

    @RequestMapping("/addproductsDetail")
    public String saveProductDetail(@ModelAttribute("Productdetail") Productdetail productdetail, @RequestParam("ProductID") Integer ID,Model model)
    {
        Product existingProduct=productService.getProductById(ID);
        productdetail.setProduct(existingProduct);
        productDetailService.saveProductDetail(productdetail);
        model.addAttribute("ProductsDetail",productDetailService.getAllProductDetailByProductId(ID));
        model.addAttribute("Product",existingProduct);
        return "redirect:productdetail/productsDetail/{id}";
       // return "ProductsDetails";
    }

    @RequestMapping("/productsDetail/edit/{id}")
    public String editProductForm(@PathVariable Integer id,Model model)
    {
        model.addAttribute("Productdetail",productDetailService.getProductdetailById(id));
        System.out.println("EDIT HELLO WORLD");
        return "edit_Productdetail";
    }

    @RequestMapping("/updateproductsDetail/{id}")
    public String UpdateProduct(@PathVariable Integer id, @ModelAttribute("Productdetail") Productdetail Productdetail,Model model)
    {
        //get Product from database by id
        Productdetail existingProductdetail=productDetailService.getProductdetailById(id);
      //  Integer ID=existingProductdetail.getProduct().getId();
        existingProductdetail.setProductName(Productdetail.getProductName());
        existingProductdetail.setProductPrice(Productdetail.getProductPrice());
        existingProductdetail.setProductSku(Productdetail.getProductSku());
        existingProductdetail.setProductDescription(Productdetail.getProductDescription());
        //save update Product object
        productDetailService.updateProductdetail(existingProductdetail);
//        model.addAttribute("ProductsDetail",productDetailService.getAllProductDetailByProductId(ID));
//        model.addAttribute("Product",productService.getProductById(ID));
        return "redirect:productdetail/productsDetail/{id}";
      //  return "ProductsDetails";
    }

    @RequestMapping("/productsDetail/delete/{id}")
    public String DeleteProductDetail(@PathVariable Integer id,Model model)
    {
       /* Integer ID=productDetailService.getProductdetailById(id).getProduct().getId();
        System.out.println("PRODUCT ID"+ID);*/
        productDetailService.deleteProductdetailbyId(id);
       /* Product existingProduct=productService.getProductById(ID);
        model.addAttribute("ProductsDetail",productDetailService.getAllProductDetailByProductId(ID));
        model.addAttribute("Product",existingProduct);*/
        return "redirect:productdetail/productsDetail/{id}";
        //  return "ProductsDetails";
    }
}
