package com.example.shopingapp.web;

import com.example.shopingapp.models.binding.ProductBindingModel;
import com.example.shopingapp.models.service.ProductServiceModel;
import com.example.shopingapp.models.service.UserServiceModel;
import com.example.shopingapp.models.views.ProductDetailsViewModel;
import com.example.shopingapp.service.ProductService;
import com.example.shopingapp.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
@RequestMapping("/products")
public class ProductController {
    private final ProductService productService;
    private final ModelMapper modelMapper;
    private final UserService userService;

    public ProductController(ProductService productService, ModelMapper modelMapper, UserService userService) {
        this.productService = productService;
        this.modelMapper = modelMapper;
        this.userService = userService;
    }

    @GetMapping("/add")
    public String add(Model model, HttpSession httpSession){
        if(httpSession.getAttribute("username")==null){
        return "redirect:/users/login";
        }
        if(!model.containsAttribute("productBindingModel")){
            model.addAttribute("productBindingModel", new ProductBindingModel());
        }
        return "add-product";
    }

    @PostMapping("/add")
    public String addConfirmed(@Valid ProductBindingModel productBindingModel, BindingResult bindingResult, RedirectAttributes redirectAttributes, HttpSession httpSession){
        if(bindingResult.hasErrors()){
            redirectAttributes.addFlashAttribute("productBindingModel", productBindingModel);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.productBindingModel", bindingResult);
            return "redirect:add";
        }
        UserServiceModel user =userService.findByUsername(httpSession.getAttribute("username").toString());
        productService.addProduct(modelMapper.map(productBindingModel, ProductServiceModel.class), user.getId());
        return "redirect:/";
    }

    @GetMapping("/details/{id}")
    public String details(@PathVariable Long id, Model model){
           ProductDetailsViewModel product = productService.findProductById(id);
            model.addAttribute("productBindingModel", product);
    return "details-product";
    }



    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id){
        productService.deleteProduct(id);

        return "redirect:/";
    }
}
