package com.ecommercewebsite.Services.ProductServiceImpl;

import com.ecommercewebsite.Services.ProductDetailService;
import com.ecommercewebsite.entity.Productdetail;
import com.ecommercewebsite.repository.ProductdetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class ProductDetailServiceImpl implements ProductDetailService {

    @Autowired
    ProductdetailRepository productdetailRepository;

    @Override
    public List<Productdetail> getAllProductsDetails() {
        return productdetailRepository.findAll();
    }

    @Override
    public Productdetail saveProductDetail(Productdetail Productdetail) {
        return productdetailRepository.save(Productdetail);
    }
    @Override
    public Productdetail getProductdetailById(Integer id) {
        return productdetailRepository.findById(id).get();
    }

    @Override
    public Productdetail updateProductdetail(Productdetail Productdetail) {
        return productdetailRepository.save(Productdetail);
    }

    @Override
    public void deleteProductdetailbyId(Integer id) {
        productdetailRepository.deleteById(id);
    }

    @Override
    public List<Productdetail> getAllProductDetailByProductId(Integer id) {
        List<Productdetail> existingdetail=productdetailRepository.findAll();
        List<Productdetail> SelectedList=new ArrayList<>();
        for (int i = 0; i < existingdetail.size(); i++) {
            if(Objects.equals(existingdetail.get(i).getProduct().getId(), id))
            {
                SelectedList.add(existingdetail.get(i));
            }
        }
        return SelectedList;
    }
}
