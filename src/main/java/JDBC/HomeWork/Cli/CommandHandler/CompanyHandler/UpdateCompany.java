package JDBC.HomeWork.Cli.CommandHandler.CompanyHandler;

import JDBC.HomeWork.Cli.CommandHandler.CommandHandler;
import JDBC.HomeWork.Storage.CompanyStorage;
/*
updateCompany id name city
 */

public class UpdateCompany implements CommandHandler {
    @Override
    public void handleCommand(String[] parameters) {
        if (parameters.length == 3){
            CompanyStorage storage = new CompanyStorage();
            long id = 0;
            try {
                id = Long.parseLong(parameters[0]);
            }catch (NumberFormatException nbe){
                System.out.println("Неверный тип данных!");
                return;
            }
            String name = parameters[1];
            String city = parameters[2];
            storage.updateCompany(id,name,city);
        }else System.out.println("Неверное число параметров!");
    }
}
