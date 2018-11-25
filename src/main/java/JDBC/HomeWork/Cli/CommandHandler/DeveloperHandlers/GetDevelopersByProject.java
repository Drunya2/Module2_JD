package JDBC.HomeWork.Cli.CommandHandler.DeveloperHandlers;

import JDBC.HomeWork.Cli.CommandHandler.CommandHandler;
import JDBC.HomeWork.Entity.Developer;
import JDBC.HomeWork.Storage.DeveloperStorage;

import java.util.List;
/*
getDevelopersByProject projectName
 */

public class GetDevelopersByProject implements CommandHandler {
    @Override
    public void handleCommand(String[] parameters) {
        if (parameters.length == 1){
            DeveloperStorage storage = new DeveloperStorage();
            List<Developer> developers = storage.getAllDevelopersByProject(parameters[0]);
            for (Developer developer : developers){
                System.out.println(developer);
            }
        }else System.out.println("Неверное число парметров!");
    }
}
