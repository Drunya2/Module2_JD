package JDBC.HomeWork.Cli.CommandHandler.ProjectHandlers;

import JDBC.HomeWork.Cli.CommandHandler.CommandHandler;
import JDBC.HomeWork.Entity.Project;
import JDBC.HomeWork.Storage.ProjectStorage;

import java.util.List;

public class GetListProjects implements CommandHandler {
    /*
    getListProjects
     */
    @Override
    public void handleCommand(String[] parameters) {
        if (parameters.length == 0){
            ProjectStorage storage = new ProjectStorage();
            List<Project> projects = storage.getAllProjects();
            for (Project project : projects){
                System.out.println(project);
            }
        }else System.out.println("Неверное число параметров");
    }
}
