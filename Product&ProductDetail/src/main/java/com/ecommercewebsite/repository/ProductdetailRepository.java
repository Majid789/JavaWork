package com.ecommercewebsite.repository;

import com.ecommercewebsite.entity.Productdetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface ProductdetailRepository extends JpaRepository<Productdetail, Integer>, JpaSpecificationExecutor<Productdetail> {
}