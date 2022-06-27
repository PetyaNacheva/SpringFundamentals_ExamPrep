package com.example.shopingapp.service;

import com.example.shopingapp.models.binding.ProductBindingModel;
import com.example.shopingapp.models.service.ProductServiceModel;
import com.example.shopingapp.models.views.ProductDetailsViewModel;
import com.example.shopingapp.models.views.ProductViewModel;

import java.util.List;

public interface ProductService {
    void addProduct(ProductServiceModel map, Long id);

    List<ProductViewModel> findAllProductsByUsername(String username);

    void deleteProduct(Long id);


    ProductDetailsViewModel findProductById(Long id);
}
