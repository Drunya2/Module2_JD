package JDBC.HomeWork.Cli.CommandHandler.ProjectHandlers;

import JDBC.HomeWork.Cli.CommandHandler.CommandHandler;
import JDBC.HomeWork.Storage.ProjectStorage;
/*
updateProject id name description companyId customerId cost
 */

public class UpdateProject implements CommandHandler {
    @Override
    public void handleCommand(String[] parameters) {
        if (parameters.length == 6) {
            ProjectStorage projectStorage = new ProjectStorage();
            String name = parameters[1];
            String description = parameters[2];
            long id = 0;
            long companyId = 0;
            long customerId = 0;
            long cost = 0;
            try {
               id = Long.parseLong(parameters[0]);
               companyId = Long.parseLong(parameters[3]);
               customerId = Long.parseLong(parameters[4]);
               cost = Long.parseLong(parameters[5]);
            }catch (NumberFormatException nbe){
                System.out.println("Неверный типа данных!");
                return;
            }
            projectStorage.updateProject(id,name,description,companyId,customerId,cost);
        }else System.out.println("Неверное число параметров!");
    }
}
