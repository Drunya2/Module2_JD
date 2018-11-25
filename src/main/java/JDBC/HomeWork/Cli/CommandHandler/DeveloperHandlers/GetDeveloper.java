package JDBC.HomeWork.Cli.CommandHandler.DeveloperHandlers;

import JDBC.HomeWork.Cli.CommandHandler.CommandHandler;
import JDBC.HomeWork.Entity.Developer;
import JDBC.HomeWork.Storage.DeveloperStorage;

public class GetDeveloper implements CommandHandler {

    /*
   getDeveloper id
     */

    @Override
    public void handleCommand(String[] parameters) {
        if (parameters.length == 1){
            DeveloperStorage developerStorage = new DeveloperStorage();
            long id = 0;
            try {
                id = Long.parseLong(parameters[0]);
            }catch (NumberFormatException nbe){
                System.out.println("Неверный типа данных!");
                return;
            }
            Developer developer = developerStorage.getDeveloperById(id);
            if (developer == null) System.out.println("Developer not found!");
            else System.out.println(developer);
        }
    }
}
