package coffee_shop.repository;

import coffee_shop.model.CategoryEnum;
import coffee_shop.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {

    //List<Order> findAllByCategory_Name(CategoryEnum categoryName);


    List<Order> findAllByOrderByPriceDesc();
   // @Query(value = "select o.employee from Order o order by count(o)")
   // List<Order> findAllByEmployeeOrderByCount();


}
