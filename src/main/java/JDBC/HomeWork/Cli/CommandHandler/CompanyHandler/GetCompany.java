package JDBC.HomeWork.Cli.CommandHandler.CompanyHandler;

import JDBC.HomeWork.Cli.CommandHandler.CommandHandler;
import JDBC.HomeWork.Entity.Company;
import JDBC.HomeWork.Storage.CompanyStorage;

/*
getCompany id
 */
public class GetCompany implements CommandHandler {
    @Override
    public void handleCommand(String[] parameters) {
        if (parameters.length == 1){
            CompanyStorage storage = new CompanyStorage();
            long id = 0;
            try {
                id = Long.parseLong(parameters[0]);
            }catch (NumberFormatException nbe){
                System.out.println("Неверный тип данных!");
                return;
            }
            Company company = storage.getCompanyById(id);
            if (company == null) System.out.println("Company not found!");
            else System.out.println(company);
        }else System.out.println("Неверное число параметров!");
    }
}
