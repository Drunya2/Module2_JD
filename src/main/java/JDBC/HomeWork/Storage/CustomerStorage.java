package JDBC.HomeWork.Storage;

import JDBC.HomeWork.Entity.Customer;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CustomerStorage extends Storage{

    private PreparedStatement createCustomerSt;
    private PreparedStatement updateCustomerSt;

    public CustomerStorage(){
        initDriver();
        initConnection();
        initStatements();
    }

    private void initStatements(){
        try {
            createCustomerSt = connection.prepareStatement("insert into customers (customer_name, country)" +
                    " values (?,?)");
            updateCustomerSt = connection.prepareStatement("update customers set customer_name = ?," +
                    "country = ? where id = ?");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void createCustomer(String name, String country){
        try {
            createCustomerSt.setString(1, name);
            createCustomerSt.setString(2, country);
            createCustomerSt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteCustomer(long id){
        String sql = "delete from customers where id = " + id;
        try {
            statement.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateCustomer(long id, String name, String country){
        try {
            updateCustomerSt.setString(1, name);
            updateCustomerSt.setString(2, country);
            updateCustomerSt.setLong(3, id);
            updateCustomerSt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Customer getCustomerById(long id){
        String sql = "select id, customer_name, country from customers where id = " + id;

        ResultSet rs = null;
        try {
            rs = statement.executeQuery(sql);
            if (rs.first()){
                Customer customer = new Customer();
                customer.setId(rs.getLong("id"));
                customer.setName(rs.getString("customer_name"));
                customer.setCountry(rs.getString("country"));
                return customer;
            }else return null;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }finally {
            closeResultSet(rs);
        }
    }

    public List<Customer> getAllCustomers(){
        List<Customer> customers = new ArrayList<>();
        String sql = "select id, customer_name, country from customers";

        ResultSet rs = null;
        try {
            rs = statement.executeQuery(sql);
            while (rs.next()){
                Customer customer = new Customer();
                customer.setId(rs.getLong("id"));
                customer.setName(rs.getString("customer_name"));
                customer.setCountry(rs.getString("country"));
                customers.add(customer);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            closeResultSet(rs);
        }
        return customers;
    }
}
