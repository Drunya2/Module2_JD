package JDBC.HomeWork.Cli.CommandHandler.DeveloperHandlers;

import JDBC.HomeWork.Cli.CommandHandler.CommandHandler;
import JDBC.HomeWork.Entity.Developer;
import JDBC.HomeWork.Storage.DeveloperStorage;

/*
getListDevelopers
 */
public class GetListDevelopers implements CommandHandler {

    @Override
    public void handleCommand(String[] parameters) {
        if (parameters.length == 0) {
            DeveloperStorage developerStorage = new DeveloperStorage();
            for (Developer developer : developerStorage.getAllDevelopers()){
                System.out.println(developer);
            }
        }
    }
}
