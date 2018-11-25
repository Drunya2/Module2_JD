package JDBC.HomeWork.Cli.CommandHandler.CustomerHandler;

import JDBC.HomeWork.Cli.CommandHandler.CommandHandler;
import JDBC.HomeWork.Storage.CustomerStorage;
/*
updateCustomer id name country
 */

public class UpdateCustomer implements CommandHandler {

    @Override
    public void handleCommand(String[] parameters) {
        if (parameters.length == 3) {
            CustomerStorage storage = new CustomerStorage();
            long id = 0;
            try {
                id = Long.parseLong(parameters[0]);
            }catch (NumberFormatException nbe){
                System.out.println("Неверный тип данных!");
                return;
            }
            String name = parameters[1];
            String country = parameters[2];
            storage.updateCustomer(id, name, country);
        }else System.out.println("Неверное число параметров!");
    }
}
