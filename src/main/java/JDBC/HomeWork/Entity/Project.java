package JDBC.HomeWork.Entity;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Project {
    private long id;
    private String name;
    private String description;
    private long companyId;
    private long customerId;
    private long cost;

    @Override
    public String toString() {
        return "Project{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", companyId=" + companyId +
                ", customerId=" + customerId +
                ", cost=" + cost +
                '}';
    }
}
