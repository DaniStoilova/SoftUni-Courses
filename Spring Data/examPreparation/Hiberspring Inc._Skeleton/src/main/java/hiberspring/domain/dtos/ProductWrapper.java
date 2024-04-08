package hiberspring.domain.dtos;

import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.*;
import java.util.List;

@XmlRootElement(name="products")
@XmlAccessorType(XmlAccessType.FIELD)
public class ProductWrapper {

    @XmlElement(name="product")
    @NotNull
    private List<ProductImport> product;

    public List<ProductImport> getProduct() {
        return product;
    }

    public void setProduct(List<ProductImport> product) {
        this.product = product;
    }
}


