package JDBC.HomeWork.Storage;

import JDBC.HomeWork.Entity.Project;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProjectStorage extends Storage {
    private PreparedStatement createProjectSt;
    private PreparedStatement updateProjectSt;

    public ProjectStorage(){
        initDriver();
        initConnection();
        initStatements();
    }

    private void initStatements(){
        try {
            createProjectSt = connection.prepareStatement("insert into projects (project_name, description, " +
                    "id_company, id_customer, cost) values (?, ?, ?,?,?)");

            updateProjectSt = connection.prepareStatement("update projects set project_name = ?, " +
                    "description = ?, id_company = ?, id_customer = ?, cost= ? where id = ?");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void createProject(String name, String description, long companyId, long customerId, long cost){
        try {
            createProjectSt.setString(1, name);
            createProjectSt.setString(2, description);
            createProjectSt.setLong(3, companyId);
            createProjectSt.setLong(4, customerId);
            createProjectSt.setLong(5, cost);
            createProjectSt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteProject(long id){
        String sql = "delete from projects where id = " + id;
        try {
            statement.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateProject(long id, String name, String description, long companyId, long customerId, long cost){
        try {
            updateProjectSt.setString(1, name);
            updateProjectSt.setString(2, description);
            updateProjectSt.setLong(3, companyId);
            updateProjectSt.setLong(4, customerId);
            updateProjectSt.setLong(5, cost);
            updateProjectSt.setLong(6, id);
            updateProjectSt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Project getProjectById(long id){
        String sql = "select id, project_name, description, id_company, id_customer, cost " +
                "from projects where id = " + id;

        ResultSet rs = null;
        try {
            rs = statement.executeQuery(sql);
            if (rs.first()){
                Project project = new Project();
                project.setId(rs.getLong("id"));
                project.setName(rs.getString("project_name"));
                project.setDescription(rs.getString("Description"));
                project.setCompanyId(rs.getLong("id_company"));
                project.setCustomerId(rs.getLong("id_customer"));
                project.setCost(rs.getLong("cost"));
                return project;
            }else return null;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }finally {
            closeResultSet(rs);
        }
    }

    public List<Project> getAllProjects(){
        List<Project> projects = new ArrayList<>();
        String sql = "select id, project_name, description, id_company, id_customer, cost from projects";

        ResultSet rs = null;
        try {
            rs = statement.executeQuery(sql);
            while (rs.next()){
                Project project = new Project();
                project.setId(rs.getLong("id"));
                project.setName(rs.getString("project_name"));
                project.setDescription(rs.getString("Description"));
                project.setCompanyId(rs.getLong("id_company"));
                project.setCustomerId(rs.getLong("id_customer"));
                project.setCost(rs.getLong("cost"));
                projects.add(project);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            closeResultSet(rs);
        }
        return projects;
    }

    public List<Long> countDevelopersInProject(){
        List<Long> countDevelopers = new ArrayList<>();
        String sql = "select count(d.id) \n" +
                "from Developers d, Projects p, developers_projects dp\n" +
                "where dp.id_developer = d.id and dp.id_project = p.id\n" +
                "group by p.project_name";

        ResultSet rs = null;
        try {
            rs = statement.executeQuery(sql);
            while (rs.next()){
                long count = rs.getLong("count(d.id)");
                countDevelopers.add(count);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            closeResultSet(rs);
        }
        return countDevelopers;
    }

}
