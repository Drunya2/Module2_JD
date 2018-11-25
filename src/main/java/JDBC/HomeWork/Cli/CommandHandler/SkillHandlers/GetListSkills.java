package JDBC.HomeWork.Cli.CommandHandler.SkillHandlers;

import JDBC.HomeWork.Cli.CommandHandler.CommandHandler;
import JDBC.HomeWork.Entity.Skill;
import JDBC.HomeWork.Storage.SkillStorage;
/*
getListSkills
 */

public class GetListSkills implements CommandHandler {

    @Override
    public void handleCommand(String[] parameters) {
        if (parameters.length == 0) {
            SkillStorage skillStorage = new SkillStorage();
            for (Skill skill : skillStorage.getAllSkills()){
                System.out.println(skill);
            }
        }
    }
}
