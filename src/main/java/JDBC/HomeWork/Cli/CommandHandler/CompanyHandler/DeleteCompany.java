package JDBC.HomeWork.Cli.CommandHandler.CompanyHandler;

import JDBC.HomeWork.Cli.CommandHandler.CommandHandler;
import JDBC.HomeWork.Storage.CompanyStorage;
/*
deleteCompany id
 */

public class DeleteCompany implements CommandHandler {
    @Override
    public void handleCommand(String[] parameters) {
        if (parameters.length == 1){
            CompanyStorage storage = new CompanyStorage();
            long id = 0;
            try {
                id = Long.parseLong(parameters[0]);
            }catch (NumberFormatException nbe){
                System.out.println("Неверный типа данных!");
                return;
            }
            storage.deleteCompany(id);
        }else System.out.println("Неверное число параметров!");
    }
}
