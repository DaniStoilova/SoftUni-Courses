package exam.model.dto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name="shops")
@XmlAccessorType(XmlAccessType.FIELD)
public class ShopWrapper {
    @XmlElement(name="shop")
    private List<ShopImport> shops;

    public List<ShopImport> getShops() {
        return shops;
    }

    public void setShops(List<ShopImport> shops) {
        this.shops = shops;
    }
}
