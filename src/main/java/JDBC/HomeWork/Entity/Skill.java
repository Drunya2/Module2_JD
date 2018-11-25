package JDBC.HomeWork.Entity;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Skill {
    private long id;
    private String language;
    private String level;

    @Override
    public String toString() {
        return "Skill{" +
                "id=" + id +
                ", language='" + language + '\'' +
                ", level='" + level + '\'' +
                '}';
    }
}
