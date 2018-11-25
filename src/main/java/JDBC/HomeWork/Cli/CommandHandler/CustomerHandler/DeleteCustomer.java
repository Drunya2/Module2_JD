package JDBC.HomeWork.Cli.CommandHandler.CustomerHandler;

import JDBC.HomeWork.Cli.CommandHandler.CommandHandler;
import JDBC.HomeWork.Storage.CustomerStorage;
/*
deleteCustomer id
 */

public class DeleteCustomer implements CommandHandler {

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
        storage.deleteCustomer(id);
    }else System.out.println("Неверное число параметров!");
    }
}
