package JDBC.HomeWork.Cli.CommandHandler.SkillHandlers;

import JDBC.HomeWork.Cli.CommandHandler.CommandHandler;
import JDBC.HomeWork.Storage.SkillStorage;

/*
updateSkill id language level
 */

public class UpdateSkill implements CommandHandler {

    @Override
    public void handleCommand(String[] parameters) {
        if (parameters.length == 3) {
            SkillStorage skillStorage = new SkillStorage();
            long id = 0;
            try {
                id = Long.parseLong(parameters[0]);
            }catch (NumberFormatException nbe){
                System.out.println("Неверный тип данных!");
                return;
            }
            String language = parameters[1];
            String level = parameters[2];
            skillStorage.updateSkill(id, language, level);
        }else System.out.println("Неверное число параметров!");
    }
}
