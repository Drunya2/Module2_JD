package JDBC.HomeWork.Cli.CommandHandler.DeveloperHandlers;

import JDBC.HomeWork.Cli.CommandHandler.CommandHandler;
import JDBC.HomeWork.Storage.DeveloperStorage;

/*
getSumSalary project_name
 */

public class GetSumSalary implements CommandHandler {

    @Override
    public void handleCommand(String[] parameters) {
        if (parameters.length == 1){
            String name = parameters[0];
            DeveloperStorage developerStorage = new DeveloperStorage();
            long sum = developerStorage.getSumOfSalary(name);
            System.out.println(sum);
        }else System.out.println("Неверное число параметров!");
    }
}
