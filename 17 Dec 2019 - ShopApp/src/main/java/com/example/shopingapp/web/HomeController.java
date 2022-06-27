package com.example.shopingapp.web;

import com.example.shopingapp.models.views.ProductViewModel;
import com.example.shopingapp.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class HomeController {
    private final ProductService productService;

    public HomeController(ProductService productService) {
        this.productService = productService;
    }


    @GetMapping("/")
    public String index(HttpSession httpSession, Model model){
            if(httpSession.getAttribute("username")==null){
                return "index";
            }
            List<ProductViewModel> products = productService.findAllProductsByUsername(httpSession.getAttribute("username").toString());
            model.addAttribute("products", products);
            return "home";
    }
}
