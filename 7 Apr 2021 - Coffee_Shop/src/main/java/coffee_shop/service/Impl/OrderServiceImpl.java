package coffee_shop.service.Impl;

import coffee_shop.model.*;
import coffee_shop.model.service.OrderServiceModel;
import coffee_shop.model.service.UserServiceModel;
import coffee_shop.model.view.OrderViewModel;
import coffee_shop.repository.OrderRepository;
import coffee_shop.service.CategoryService;
import coffee_shop.service.OrderService;
import coffee_shop.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderServiceImpl implements OrderService {
    private final OrderRepository orderRepository;
    private final ModelMapper modelMapper;
    private final UserService userService;
    private final CategoryService categoryService;

    public OrderServiceImpl(OrderRepository orderRepository, ModelMapper modelMapper, UserService userService, CategoryService categoryService) {
        this.orderRepository = orderRepository;
        this.modelMapper = modelMapper;
        this.userService = userService;
        this.categoryService = categoryService;
    }

    @Override
    public void addOrder(OrderServiceModel orderServiceModel, UserServiceModel user) {
        Order order = modelMapper.map(orderServiceModel, Order.class);
        User employee = userService.findById(user);
        order.setEmployee(employee);
        Category category = categoryService.findByName(orderServiceModel.getCategory());
        order.setCategory(category);
        orderRepository.save(order);
    }

   /* @Override
    public List<OrderViewModel> findAllOrdersByCategoryName(CategoryEnum categoryName){
        return orderRepository.findAllOrderByPrice().stream().map(o->modelMapper.map(o, OrderViewModel.class)).collect(Collectors.toList());
      //  return orderRepository.findAllByCategory_Name(categoryName).stream().map(o->modelMapper.map(o, OrderViewModel.class)).collect(Collectors.toList());
    }*/

    @Override
    public List<OrderViewModel> findAllOrderByPrice(){
        return orderRepository.findAllByOrderByPriceDesc().stream().map(o->modelMapper.map(o, OrderViewModel.class)).collect(Collectors.toList());
    }

    @Override
    public void prepareOrder(Long id){
        orderRepository.deleteById(id);
    }


}
