package coffee_shop.service.Impl;

import coffee_shop.model.Category;
import coffee_shop.model.CategoryEnum;
import coffee_shop.repository.CategoryRepository;
import coffee_shop.service.CategoryService;
import org.springframework.stereotype.Service;

@Service
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public void initCategory(){
    if(categoryRepository.count()==0){
        Category drink=new Category(CategoryEnum.DRINK, 1);
        Category coffee= new Category(CategoryEnum.COFFEE, 2);
        Category cake = new Category(CategoryEnum.CAKE, 10);
        Category other = new Category(CategoryEnum.OTHER, 5);
        categoryRepository.save(drink);
        categoryRepository.save(coffee);
        categoryRepository.save(cake);
        categoryRepository.save(other);
    }
    }

    @Override
    public Category findByName(CategoryEnum name) {
        return categoryRepository.findByName(name).orElse(null);
    }
}
