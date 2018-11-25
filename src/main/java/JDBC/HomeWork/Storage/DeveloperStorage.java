package JDBC.HomeWork.Storage;

import JDBC.HomeWork.Entity.Developer;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DeveloperStorage extends Storage {

    private PreparedStatement createDeveloperSt;
    private PreparedStatement updateDeveloperSt;

    public DeveloperStorage() {
        initDriver();
        initConnection();
        initPrepareStatement();
    }

    private void initPrepareStatement() {
        try {
            createDeveloperSt = connection.prepareStatement("insert into developers (first_name, last_name, age, sex," +
                    "id_company, salary) values (?,?,?,?,?,?)");
            updateDeveloperSt = connection.prepareStatement("update developers set first_name = ?, " +
                    "last_name = ?,age = ? , sex = ?, id_company = ?, salary = ? where id = ?");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void createDeveloper(String name, String surname, long age, String sex, long companyId, long salary) {
        try {
            createDeveloperSt.setString(1, name);
            createDeveloperSt.setString(2, surname);
            createDeveloperSt.setLong(3, age);
            createDeveloperSt.setString(4, sex);
            createDeveloperSt.setLong(5, companyId);
            createDeveloperSt.setLong(6, salary);
            createDeveloperSt.executeUpdate();
        } catch (SQLException e) {
            if (!sex.equals("male") && !sex.equals("female")) {
                System.out.println("Sex in this table must be 'MALE' or 'FEMALE'!");
            } else e.printStackTrace();
        }
    }

    public void deleteDeveloper(long id) {
        String sql = "delete from developers where id = " + id;
        try {
            statement.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateDeveloper(String name, String surname, long age, String sex, long companyId, long salary, long id) {
        try {
            updateDeveloperSt.setString(1, name);
            updateDeveloperSt.setString(2, surname);
            updateDeveloperSt.setLong(3, age);
            updateDeveloperSt.setString(4, sex);
            updateDeveloperSt.setLong(5, companyId);
            updateDeveloperSt.setLong(6, salary);
            updateDeveloperSt.setLong(7, id);
            updateDeveloperSt.executeUpdate();
        } catch (SQLException e) {
            if (!sex.equals("male") && !sex.equals("female")) {
                System.out.println("Sex in this table must be 'MALE' or 'FEMALE'!");
            } else e.printStackTrace();
        }
    }

    public Developer getDeveloperById(long id) {
        String sql = "select id, first_name, last_name, age, sex, id_company, salary " +
                "from developers where id = " + id;

        ResultSet rs = null;
        try {
            rs = statement.executeQuery(sql);
            if (rs.first()) {
                Developer developer = new Developer();
                developer.setId(rs.getLong("id"));
                developer.setName(rs.getString("first_name"));
                developer.setSurname(rs.getString("last_name"));
                developer.setAge(rs.getLong("age"));
                developer.setSex(rs.getString("sex"));
                developer.setIdCompany(rs.getLong("id_company"));
                developer.setSalary(rs.getLong("salary"));
                return developer;
            } else return null;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        } finally {
            closeResultSet(rs);
        }
    }

    public List<Developer> getAllDevelopers() {
        List<Developer> developers = new ArrayList<>();
        String sql = "select id, first_name, last_name, age, sex, id_company, salary " +
                "from developers";

        ResultSet rs = null;
        try {
            rs = statement.executeQuery(sql);
            while (rs.next()) {
                Developer developer = new Developer();
                developer.setId(rs.getLong("id"));
                developer.setName(rs.getString("first_name"));
                developer.setSurname(rs.getString("last_name"));
                developer.setAge(rs.getInt("age"));
                developer.setSex(rs.getString("sex"));
                developer.setIdCompany(rs.getLong("id_company"));
                developer.setSalary(rs.getLong("salary"));
                developers.add(developer);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeResultSet(rs);
        }
        return developers;
    }

    public long getSumOfSalary(String projectName){
    String sql = "select sum(d.salary) \n" +
            "from Developers d, Projects p, developers_projects dp\n" +
            "where dp.id_developer = d.id and dp.id_project = p.id and p.project_name like '%" + projectName +
            "%'";

    long sumSalary = 0;
    ResultSet rs = null;
        try {
            rs = statement.executeQuery(sql);
            if (rs.first()){
                sumSalary = rs.getLong("sum(d.salary)");
                return sumSalary;
            }else return 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return -1;
        }finally {
            closeResultSet(rs);
        }
    }

    public List<Developer> getAllDevelopersByProject(String projectName){
        String sql = "select d.id, d.first_name, d.last_name, d.age, d.sex, d.id_company, d.salary \n" +
                "from Developers d, Projects p, developers_projects dp\n" +
                "where dp.id_developer = d.id and dp.id_project = p.id and p.project_name like '%" +
                projectName + "%'";

        List<Developer> developers = new ArrayList<>();

        ResultSet rs = null;
        try {
            rs = statement.executeQuery(sql);
            while (rs.next()){
                Developer developer = new Developer();
                developer.setId(rs.getLong("d.id"));
                developer.setName(rs.getString("d.first_name"));
                developer.setSurname(rs.getString("d.last_name"));
                developer.setAge(rs.getInt("d.age"));
                developer.setSex(rs.getString("d.sex"));
                developer.setIdCompany(rs.getLong("d.id_company"));
                developer.setSalary(rs.getLong("d.salary"));
                developers.add(developer);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            closeResultSet(rs);
        }
        return developers;
    }

    public List<Developer> getAllJavaDevelopers(){
        String sql = "select d.id, d.first_name, d.last_name, d.age, d.sex, d.id_company, d.salary \n" +
                "from Developers d, Skills s, developers_skills ds\n" +
                "where ds.id_developer = d.id and ds.id_skill = s.id and s.language like 'java'";

        List<Developer> developers = new ArrayList<>();

        ResultSet rs = null;
        try {
            rs = statement.executeQuery(sql);
            while (rs.next()){
                Developer developer = new Developer();
                developer.setId(rs.getLong("d.id"));
                developer.setName(rs.getString("d.first_name"));
                developer.setSurname(rs.getString("d.last_name"));
                developer.setAge(rs.getInt("d.age"));
                developer.setSex(rs.getString("d.sex"));
                developer.setIdCompany(rs.getLong("d.id_company"));
                developer.setSalary(rs.getLong("d.salary"));
                developers.add(developer);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            closeResultSet(rs);
        }
        return developers;
    }

    public List<Developer> getAllMiddleDevelopers(){
        String sql = "select d.id, d.first_name, d.last_name, d.age, d.sex, d.id_company, d.salary \n" +
                "from Developers d, Skills s, developers_skills ds\n" +
                "where ds.id_developer = d.id and ds.id_skill = s.id and s.skill_level like 'middle'";

        List<Developer> developers = new ArrayList<>();

        ResultSet rs = null;
        try {
            rs = statement.executeQuery(sql);
            while (rs.next()){
                Developer developer = new Developer();
                developer.setId(rs.getLong("d.id"));
                developer.setName(rs.getString("d.first_name"));
                developer.setSurname(rs.getString("d.last_name"));
                developer.setAge(rs.getInt("d.age"));
                developer.setSex(rs.getString("d.sex"));
                developer.setIdCompany(rs.getLong("d.id_company"));
                developer.setSalary(rs.getLong("d.salary"));
                developers.add(developer);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            closeResultSet(rs);
        }
        return developers;
    }
}
