package coffee_shop.model;

import javax.persistence.*;

@Entity
@Table(name = "category")
public class Category extends BaseEntity {
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private CategoryEnum name;
    @Column
    private int neededTime;

    public Category() {
    }

    public Category(CategoryEnum name, int neededTime) {
        this.name = name;
        this.neededTime = neededTime;
    }

    public CategoryEnum getName() {
        return name;
    }

    public void setName(CategoryEnum name) {
        this.name = name;
    }

    public int getNeededTime() {
        return neededTime;
    }

    public void setNeededTime(int neededTime) {
        this.neededTime = neededTime;
    }
}
