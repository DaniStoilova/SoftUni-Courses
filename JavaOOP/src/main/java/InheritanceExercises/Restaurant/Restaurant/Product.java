package InheritanceExercises.Restaurant.Restaurant;

import java.math.BigDecimal;

public class Product {
    private String name;
    private BigDecimal price;

    public String getName() {
        return name;
    }

    public Product(String name, BigDecimal price) {
        this.name = name;
        this.price = price;
    }

    public BigDecimal getPrice() {
        return price;
    }
}
