package JDBC.HomeWork.Cli.CommandHandler.CompanyHandler;

import JDBC.HomeWork.Cli.CommandHandler.CommandHandler;
import JDBC.HomeWork.Storage.CompanyStorage;
/*
createCompany name city
 */

public class CreateCompany implements CommandHandler {

    @Override
    public void handleCommand(String[] parameters) {
        if (parameters.length == 2){
            CompanyStorage storage = new CompanyStorage();
            String name = parameters[0];
            String city = parameters[1];
            storage.createCompany(name, city);
        }else System.out.println("Неверное число параметров!");
    }
}
