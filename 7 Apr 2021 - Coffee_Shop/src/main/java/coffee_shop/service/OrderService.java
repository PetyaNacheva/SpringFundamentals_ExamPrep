package coffee_shop.service;

import coffee_shop.model.CategoryEnum;
import coffee_shop.model.view.OrderViewModel;
import coffee_shop.model.service.OrderServiceModel;
import coffee_shop.model.service.UserServiceModel;

import java.util.List;

public interface OrderService {
    void addOrder(OrderServiceModel map, UserServiceModel user);

  //  List<OrderViewModel> findAllOrdersByCategoryName(CategoryEnum categoryName);

    List<OrderViewModel> findAllOrderByPrice();

    void prepareOrder(Long id);
}
