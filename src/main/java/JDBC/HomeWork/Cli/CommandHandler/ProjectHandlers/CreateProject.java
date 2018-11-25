package JDBC.HomeWork.Cli.CommandHandler.ProjectHandlers;

import JDBC.HomeWork.Cli.CommandHandler.CommandHandler;
import JDBC.HomeWork.Storage.ProjectStorage;
/*
createProject name description companyId customerId cost
 */

public class CreateProject implements CommandHandler {
    @Override
    public void handleCommand(String[] parameters) {
        if (parameters.length == 5) {
            ProjectStorage projectStorage = new ProjectStorage();
            String name = parameters[0];
            String description = parameters[1];
            long companyId = 0;
            long customerId = 0;
            long cost = 0;
            try {
                companyId = Long.parseLong(parameters[2]);
                customerId = Long.parseLong(parameters[3]);
                cost = Long.parseLong(parameters[4]);
            }catch (NumberFormatException nbe){
                System.out.println("Неверный типа данных!");
                return;
            }
            projectStorage.createProject(name, description, companyId, customerId, cost);
        }else System.out.println("Неверное число параметров!");
    }
}
