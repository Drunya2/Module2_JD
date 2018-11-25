package JDBC.HomeWork.Cli.CommandHandler.DeveloperHandlers;

import JDBC.HomeWork.Cli.CommandHandler.CommandHandler;
import JDBC.HomeWork.Storage.DeveloperStorage;

/*
deleteDeveloper id
 */


public class DeleteDeveloper implements CommandHandler {
    @Override
    public void handleCommand(String[] parameters) {
        if (parameters.length == 1) {
            DeveloperStorage developerStorage = new DeveloperStorage();
            long id = 0;
            try {
                id = Long.parseLong(parameters[0]);
            }catch (NumberFormatException nbe){
                System.out.println("Неверный тип данных!");
            }
            developerStorage.deleteDeveloper(id);
        }else System.out.println("Неверное число параметров!");
    }
}
