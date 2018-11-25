package JDBC.HomeWork.Cli.CommandHandler.CustomerHandler;

import JDBC.HomeWork.Cli.CommandHandler.CommandHandler;
import JDBC.HomeWork.Entity.Customer;
import JDBC.HomeWork.Storage.CustomerStorage;

import java.util.List;
/*
getListCustomers
 */

public class GetListCustomers implements CommandHandler {
    @Override
    public void handleCommand(String[] parameters) {
        if (parameters.length == 0){
            CustomerStorage storage = new CustomerStorage();
            List<Customer> customers = storage.getAllCustomers();
            for (Customer customer : customers){
                System.out.println(customer);
            }
        }else System.out.println("Неверное число параметров!");
    }
}
