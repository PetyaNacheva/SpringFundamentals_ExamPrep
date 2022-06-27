package com.example.shopingapp.service.impl;

import com.example.shopingapp.models.binding.ProductBindingModel;
import com.example.shopingapp.models.entity.Category;
import com.example.shopingapp.models.entity.Product;
import com.example.shopingapp.models.entity.Sex;
import com.example.shopingapp.models.entity.User;
import com.example.shopingapp.models.service.ProductServiceModel;
import com.example.shopingapp.models.views.ProductDetailsViewModel;
import com.example.shopingapp.models.views.ProductViewModel;
import com.example.shopingapp.repositories.ProductRepository;
import com.example.shopingapp.repositories.UserRepository;
import com.example.shopingapp.service.CategoryService;
import com.example.shopingapp.service.ProductService;
import com.example.shopingapp.service.SexEnumService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;
    private final ModelMapper modelMapper;
    private final UserRepository userRepository;
    private final CategoryService categoryService;
    private final SexEnumService sexEnumService;

    public ProductServiceImpl(ProductRepository productRepository, ModelMapper modelMapper, UserRepository userRepository, CategoryService categoryService, SexEnumService sexEnumService) {
        this.productRepository = productRepository;
        this.modelMapper = modelMapper;
        this.userRepository = userRepository;
        this.categoryService = categoryService;
        this.sexEnumService = sexEnumService;
    }

    @Override
    public void addProduct(ProductServiceModel productServiceModel, Long id) {
      User user = userRepository.findById(id).orElse(null);
        Product product = modelMapper.map(productServiceModel, Product.class);
        product.setOwner(user);
        Category category = categoryService.findByName(productServiceModel.getCategory());
        product.setCategory(category);
        Sex sex = sexEnumService.findByName(productServiceModel.getSex());
        product.setSex(sex);
        productRepository.save(product);
    }

    @Override
    public List<ProductViewModel> findAllProductsByUsername(String username) {
        return productRepository.findByOwner_Username(username).stream().map(p->modelMapper.map(p, ProductViewModel.class)).collect(Collectors.toList());
    }

    @Override
    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }

    @Override
    public ProductDetailsViewModel findProductById(Long id) {
        return productRepository.findById(id).map(p->modelMapper.map(p, ProductDetailsViewModel.class)).orElse(null);
    }
}
