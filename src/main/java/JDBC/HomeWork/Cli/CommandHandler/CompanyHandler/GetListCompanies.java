package JDBC.HomeWork.Cli.CommandHandler.CompanyHandler;

import JDBC.HomeWork.Cli.CommandHandler.CommandHandler;
import JDBC.HomeWork.Entity.Company;
import JDBC.HomeWork.Storage.CompanyStorage;

import java.util.List;

/*
getListCompanies
 */

public class GetListCompanies implements CommandHandler {
    @Override
    public void handleCommand(String[] parameters) {
        if (parameters.length == 0){
            CompanyStorage storage = new CompanyStorage();
            List<Company> companies = storage.getAllCompanies();
            for (Company company : companies){
                System.out.println(company);
            }
        }else System.out.println("Неверное число параметров!");
    }
}
