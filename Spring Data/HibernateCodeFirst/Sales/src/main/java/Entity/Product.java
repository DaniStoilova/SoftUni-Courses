package Entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.util.Set;

@Getter
@Setter
@Entity
@Table
public class Product extends BaseEntity{

    @Column(name = "name",length = 50,nullable = false)
    private String name;

    @Column(name = "quantity")
    private Double quantity;

    @Column(name="price", scale = 2,precision = 5)
    private BigDecimal price;

    @OneToMany(mappedBy = "product")
    private Set<Sale> sales;


}
