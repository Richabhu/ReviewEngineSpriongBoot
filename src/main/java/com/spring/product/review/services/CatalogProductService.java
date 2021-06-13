package com.spring.product.review.services;

import com.spring.product.review.models.CatalogProduct;
import com.spring.product.review.repository.CatalogProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CatalogProductService {

    @Autowired
    CatalogProductRepository catalogProductRepository;

    public CatalogProduct createProduct(CatalogProduct catalogProduct)
    {
        return catalogProductRepository.save(catalogProduct);
    }

    public CatalogProduct getProductById(int productId){
        Optional<CatalogProduct> product = catalogProductRepository.findById(productId);

        if(product.isPresent()){
            CatalogProduct catalogProduct = product.get();
            return  catalogProduct;
        }
        return null;
    }

    public CatalogProduct update(CatalogProduct catalogProduct)
    {
        return catalogProductRepository.save(catalogProduct);
    }
}
