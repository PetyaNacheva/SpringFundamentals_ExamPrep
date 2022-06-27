package coffee_shop.web;

import coffee_shop.model.binding.OrderAddBindingModel;
import coffee_shop.model.service.OrderServiceModel;
import coffee_shop.model.service.UserServiceModel;
import coffee_shop.service.OrderService;
import coffee_shop.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
@RequestMapping("/orders")
public class OrderController {

    private final OrderService orderService;
    private final ModelMapper modelMapper;
    private final UserService userService;

    public OrderController(OrderService orderService, ModelMapper modelMapper, UserService userService) {
        this.orderService = orderService;
        this.modelMapper = modelMapper;
        this.userService = userService;
    }

    @GetMapping("/add")
    public String add(Model model, HttpSession httpSession){
        if(httpSession.getAttribute("username")==null){
            return "redirect:/users/login";
        }
        if(!model.containsAttribute("orderAddBindingModel")){
            model.addAttribute("orderAddBindingModel", new OrderAddBindingModel());
        }
        return "order-add";
    }

    @PostMapping("/add")
    public String addConfirmed(@Valid OrderAddBindingModel orderAddBindingModel,
                               BindingResult bindingResult, RedirectAttributes redirectAttributes, HttpSession httpSession){

        if(bindingResult.hasErrors()){
            redirectAttributes.addFlashAttribute("orderAddBindingModel", orderAddBindingModel);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.orderAddBindingModel", bindingResult);
            return "redirect:add";
        }

        UserServiceModel user = userService.findByUsernameAndPassword(httpSession.getAttribute("username").toString(), httpSession.getAttribute("password").toString());
        orderService.addOrder(modelMapper.map(orderAddBindingModel, OrderServiceModel.class), user);
        return "redirect:/";
    }

    @GetMapping("/ready/{id}")
    public String ready(@PathVariable Long id){
        orderService.prepareOrder(id);

        return "redirect:/";
    }
}
