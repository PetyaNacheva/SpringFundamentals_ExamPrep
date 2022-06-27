package coffee_shop.model.binding;

import coffee_shop.model.Category;
import coffee_shop.model.CategoryEnum;
import coffee_shop.model.User;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Column;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

public class OrderAddBindingModel {
    private Long id;
    @NotBlank(message = "name is required")
    @Size(min = 3, max = 20, message = "name length must be between 3 and 20 chars")
    private String name;
    @DecimalMin(value = "0", message = "price must be positive number")
    private BigDecimal price;
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
    @PastOrPresent(message = "time must be past or present")
    private LocalDateTime orderTime;
    @NotNull(message = "category is required")
    private CategoryEnum category;
    @NotBlank(message = "description is required")
    @Size(min = 5, message = "description must be at least 5 chars")
    private String description;

    public OrderAddBindingModel() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public LocalDateTime getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(LocalDateTime orderTime) {
        this.orderTime = orderTime;
    }

    public CategoryEnum getCategory() {
        return category;
    }

    public void setCategory(CategoryEnum category) {
        this.category = category;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
