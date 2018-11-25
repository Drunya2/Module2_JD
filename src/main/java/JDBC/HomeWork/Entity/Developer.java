package JDBC.HomeWork.Entity;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Developer {
    private long id;
    private String name;
    private String surname;
    private long age;
    private String sex;
    private long idCompany;
    private long salary;

    @Override
    public String toString() {
        return "Developer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", age=" + age +
                ", sex='" + sex + '\'' +
                ", idCompany=" + idCompany +
                ", salary=" + salary +
                '}';
    }
}
