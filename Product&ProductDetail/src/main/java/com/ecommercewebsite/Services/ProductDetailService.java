package com.ecommercewebsite.Services;

import com.ecommercewebsite.entity.Productdetail;

import java.util.List;

public interface ProductDetailService {

    List<Productdetail> getAllProductsDetails();

    Productdetail saveProductDetail(Productdetail Productdetail);

    Productdetail getProductdetailById(Integer id);

    Productdetail updateProductdetail(Productdetail Productdetail);

    void deleteProductdetailbyId(Integer id);

    List<Productdetail> getAllProductDetailByProductId(Integer id);


}
