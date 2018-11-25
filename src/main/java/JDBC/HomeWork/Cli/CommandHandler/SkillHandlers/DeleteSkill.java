package JDBC.HomeWork.Cli.CommandHandler.SkillHandlers;

import JDBC.HomeWork.Cli.CommandHandler.CommandHandler;
import JDBC.HomeWork.Storage.SkillStorage;

/*
deleteSkill id
 */

public class DeleteSkill implements CommandHandler {

    @Override
    public void handleCommand(String[] parameters) {
        if (parameters.length == 1){
            SkillStorage skillStorage = new SkillStorage();
            long id = 0;
            try {
                id = Long.parseLong(parameters[0]);
            }catch (NumberFormatException nbe){
                System.out.println("Неверный типа данных!");
                return;
            }
            skillStorage.deleteSkill(id);
        }else System.out.println("Неверное число параметров!");
    }
}
