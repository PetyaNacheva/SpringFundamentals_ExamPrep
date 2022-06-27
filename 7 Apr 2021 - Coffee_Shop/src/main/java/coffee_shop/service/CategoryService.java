package coffee_shop.service;

import coffee_shop.model.Category;
import coffee_shop.model.CategoryEnum;

public interface CategoryService {


     void initCategory();

    Category findByName(CategoryEnum category);
}
