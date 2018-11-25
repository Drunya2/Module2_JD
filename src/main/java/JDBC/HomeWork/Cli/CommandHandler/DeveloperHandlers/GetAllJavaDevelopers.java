package JDBC.HomeWork.Cli.CommandHandler.DeveloperHandlers;

import JDBC.HomeWork.Cli.CommandHandler.CommandHandler;
import JDBC.HomeWork.Entity.Developer;
import JDBC.HomeWork.Storage.DeveloperStorage;

import java.util.List;
/*
getAllJavaDevelopers
 */

public class GetAllJavaDevelopers implements CommandHandler {
    @Override
    public void handleCommand(String[] parameters) {
        if (parameters.length == 0){
            DeveloperStorage storage = new DeveloperStorage();
            List<Developer> developers = storage.getAllJavaDevelopers();
            for (Developer developer : developers){
                System.out.println(developer);
            }
        }else System.out.println("Неверное число параметров!");
    }
}
