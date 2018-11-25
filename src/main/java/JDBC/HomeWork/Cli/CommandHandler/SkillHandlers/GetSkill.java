package JDBC.HomeWork.Cli.CommandHandler.SkillHandlers;

import JDBC.HomeWork.Cli.CommandHandler.CommandHandler;
import JDBC.HomeWork.Entity.Skill;
import JDBC.HomeWork.Storage.SkillStorage;

/*
getSkill id
 */

public class GetSkill implements CommandHandler {

    @Override
    public void handleCommand(String[] parameters) {
        if (parameters.length == 1) {
            SkillStorage skillStorage = new SkillStorage();
            long id = 0;
            try {
                id = Long.parseLong(parameters[0]);
            }catch (NumberFormatException nbe){
                System.out.println("Неверный тип данных!");
                return;
            }
            Skill skill = skillStorage.getSkillById(id);
            if (skill == null) System.out.println("Skill not found!");
            else System.out.println(skill);

        }else System.out.println("Неверное число параметров!");
    }
}
