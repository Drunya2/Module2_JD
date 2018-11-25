package JDBC.HomeWork.Cli.CommandHandler.CustomerHandler;

import JDBC.HomeWork.Cli.CommandHandler.CommandHandler;
import JDBC.HomeWork.Storage.CustomerStorage;
/*
createCustomer name country
 */

public class CreateCustomer implements CommandHandler {
    @Override
    public void handleCommand(String[] parameters) {
        if (parameters.length == 2){
            CustomerStorage storage = new CustomerStorage();
            String name = parameters[0];
            String county = parameters[1];
            storage.createCustomer(name, county);
        }else System.out.println("Неверное число параметров!");
    }
}
