package restproject.demo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Product {
    private @Id @GeneratedValue Long id;
    private String name;
    private int price;
    private String measureUnit;

    public Product(){}

    public Product(String name, int price, String mesaureUnit){
        this.name = name;
        this.price = price;
        this.measureUnit = mesaureUnit;
    }


     public void setId(Long id){
         this.id = id;
     }
    public Long getId(){
         return id;
     }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getMeasureUnit() {
        return measureUnit;
    }

    public void setMeasureUnit(String measureUnit) {
        this.measureUnit = measureUnit;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public String toString() {
        return String.format("Product{id = %s, name = %s, price = %d, measureUnit = %s", id, name, price, measureUnit);
    }
}
