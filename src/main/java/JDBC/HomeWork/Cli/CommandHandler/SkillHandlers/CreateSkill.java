package JDBC.HomeWork.Cli.CommandHandler.SkillHandlers;

import JDBC.HomeWork.Cli.CommandHandler.CommandHandler;
import JDBC.HomeWork.Storage.SkillStorage;

/*
createSkill language level
 */

public class CreateSkill implements CommandHandler {

    @Override
    public void handleCommand(String[] parameters) {
        if (parameters.length == 2) {
            SkillStorage skillStorage = new SkillStorage();
            skillStorage.createSkill(parameters[0], parameters[1]);
        }else System.out.println("Неверное число параметров");
    }
}
