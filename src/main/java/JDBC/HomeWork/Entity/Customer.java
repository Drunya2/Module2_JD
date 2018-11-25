package JDBC.HomeWork.Entity;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Customer {
    private long id;
    private String name;
    private String country;

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", country='" + country + '\'' +
                '}';
    }
}
