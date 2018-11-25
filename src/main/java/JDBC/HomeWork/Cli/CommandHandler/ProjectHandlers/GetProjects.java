package JDBC.HomeWork.Cli.CommandHandler.ProjectHandlers;

import JDBC.HomeWork.Cli.CommandHandler.CommandHandler;
import JDBC.HomeWork.Entity.Project;
import JDBC.HomeWork.Storage.ProjectStorage;

import java.util.List;

/*
getProjects
 */

public class GetProjects implements CommandHandler {
    @Override
    public void handleCommand(String[] parameters) {
        if (parameters.length == 0){
            ProjectStorage storage = new ProjectStorage();
            List<Project> projects = storage.getAllProjects();
            List<Long> costs = storage.countDevelopersInProject();
            for (int i = 0; i<projects.size();i++){
                System.out.println("Name - " + projects.get(i).getName() + " | Description - " +
                        projects.get(i).getDescription() + " | CountDevelopers - " + costs.get(i));
            }
        }else System.out.println("Неверное число параметров!");
    }
}
