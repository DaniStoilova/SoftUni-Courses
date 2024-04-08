package softuni.exam.models.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="countries")
public class Country extends  BaseEntity{
    @Column(unique = true,name="country_name",nullable = false)
    private String countryName;

    @Column(nullable = false)
    private String currency;


    public Country() {
    }

    public String getCountryName() {
        return countryName;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }
}
