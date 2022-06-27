package coffee_shop.web;

import coffee_shop.model.view.OrderViewModel;
import coffee_shop.model.view.UserViewModel;
import coffee_shop.service.OrderService;
import coffee_shop.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class HomeController {
    private final OrderService orderService;
    private final UserService userService;

    public HomeController(OrderService orderService, UserService userService) {
        this.orderService = orderService;
        this.userService = userService;
    }

    @GetMapping("/")
    public String index(HttpSession httpSession, Model model) {

            if(httpSession.getAttribute("username")==null){
                return "index";
            }
        List<OrderViewModel> orders = orderService.findAllOrderByPrice();
        // model.addAttribute("coffee", orderService.findAllOrdersByCategoryName(CategoryEnum.COFFEE));
         //   model.addAttribute("drinks", orderService.findAllOrdersByCategoryName(CategoryEnum.DRINK));
           // model.addAttribute("cakes", orderService.findAllOrdersByCategoryName(CategoryEnum.CAKE));
            //model.addAttribute("other", orderService.findAllOrdersByCategoryName(CategoryEnum.OTHER));
        model.addAttribute("orders", orders);
        model.addAttribute("totalTime",
                orders
                        .stream()
                        .map(orderViewModel -> orderViewModel.getCategory().getNeededTime()).reduce(Integer::sum)
                        .orElse(0));
        List<UserViewModel> usersByOrders = userService.findAllUsersByCountOfOrdersOrderByCountDesc();
        model.addAttribute("usersByOrders", usersByOrders);
            //model.addAttribute("user", )
        return "home";
    }
}
