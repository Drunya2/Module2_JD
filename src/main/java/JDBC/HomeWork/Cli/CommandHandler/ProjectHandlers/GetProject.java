package JDBC.HomeWork.Cli.CommandHandler.ProjectHandlers;

import JDBC.HomeWork.Cli.CommandHandler.CommandHandler;
import JDBC.HomeWork.Entity.Project;
import JDBC.HomeWork.Storage.ProjectStorage;

public class GetProject implements CommandHandler {
    /*
    getProject id
     */
    @Override
    public void handleCommand(String[] parameters) {
        if (parameters.length == 1){
            ProjectStorage storage = new ProjectStorage();
            long id = 0;
            try {
                id = Long.parseLong(parameters[0]);
            }catch (NumberFormatException nbe){
                System.out.println("Неверный тип данных!");
                return;
            }
            Project project = storage.getProjectById(id);
            if (project == null) System.out.println("Project not found!");
            else System.out.println(project);
        }else System.out.println("Неверное число параметров!");
    }
}
