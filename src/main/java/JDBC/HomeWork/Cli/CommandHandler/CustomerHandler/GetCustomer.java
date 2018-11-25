package JDBC.HomeWork.Cli.CommandHandler.CustomerHandler;

import JDBC.HomeWork.Cli.CommandHandler.CommandHandler;
import JDBC.HomeWork.Entity.Customer;
import JDBC.HomeWork.Storage.CustomerStorage;
/*
getCustomer id
 */

public class GetCustomer implements CommandHandler {
    @Override
    public void handleCommand(String[] parameters) {
        if (parameters.length == 1){
            CustomerStorage storage = new CustomerStorage();
            long id = 0;
            try {
                id = Long.parseLong(parameters[0]);
            }catch (NumberFormatException nbe){
                System.out.println("Неверный тип данных!");
                return;
            }
            Customer customer = storage.getCustomerById(id);
            if (customer==null) System.out.println("Customer not found!");
            else System.out.println(customer);
        }else System.out.println("Неверное число параметров!");
    }
}
