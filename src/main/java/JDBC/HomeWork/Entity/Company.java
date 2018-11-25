package JDBC.HomeWork.Entity;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Company {
    private long id;
    private String name;
    private String city;

    @Override
    public String toString() {
        return "Company{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", city='" + city + '\'' +
                '}';
    }
}
