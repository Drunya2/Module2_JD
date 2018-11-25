package JDBC.HomeWork.Cli.CommandHandler.ProjectHandlers;

import JDBC.HomeWork.Cli.CommandHandler.CommandHandler;
import JDBC.HomeWork.Storage.ProjectStorage;

public class DeleteProject implements CommandHandler {
    /*
    deleteProject id
     */
    @Override
    public void handleCommand(String[] parameters) {
        if (parameters.length == 1){
            ProjectStorage storage = new ProjectStorage();
            long id = 0;
            try {
                id = Long.parseLong(parameters[0]);
            }catch (NumberFormatException nbe){
                System.out.println("Неверный типа данных!");
                return;
            }
            storage.deleteProject(id);
        }else System.out.println("Неверное число параметров!");
    }
}
