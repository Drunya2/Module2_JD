package JDBC.HomeWork.Storage;

import JDBC.HomeWork.Entity.Company;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CompanyStorage extends Storage{

    private PreparedStatement createCompanySt;
    private PreparedStatement updateCompanySt;

    public CompanyStorage(){
        initDriver();
        initConnection();
        initStatements();
    }

    private void initStatements(){
        try {
            createCompanySt = connection.prepareStatement("insert into companies(name, city) values (?, ?)");
            updateCompanySt = connection.prepareStatement("update companies set name = ?, city = ? where id = ?");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void createCompany(String name, String city){
        try {
            createCompanySt.setString(1, name);
            createCompanySt.setString(2, city);
            createCompanySt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteCompany(long id){
        String sql = "delete from companies where id = " + id;
        try {
            statement.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateCompany(long id, String name, String city){
        try {
            updateCompanySt.setString(1, name);
            updateCompanySt.setString(2, city);
            updateCompanySt.setLong(3, id);
            updateCompanySt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Company getCompanyById(long id){
        String sql = "select id, name, city from companies where id = " + id;

        ResultSet rs = null;
        try {
            rs = statement.executeQuery(sql);
            if (rs.first()){
                Company company = new Company();
                company.setId(rs.getLong("id"));
                company.setName(rs.getString("name"));
                company.setCity(rs.getString("city"));
                return company;
            }else return null;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }finally {
            closeResultSet(rs);
        }
    }

    public List<Company> getAllCompanies(){
        List<Company> companies = new ArrayList<>();
        String sql = "select id, name, city from companies";

        ResultSet rs = null;
        try {
            rs = statement.executeQuery(sql);
            while (rs.next()){
                Company company = new Company();
                company.setId(rs.getLong("id"));
                company.setName(rs.getString("name"));
                company.setCity(rs.getString("city"));
                companies.add(company);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            closeResultSet(rs);
        }
        return companies;
    }
}
