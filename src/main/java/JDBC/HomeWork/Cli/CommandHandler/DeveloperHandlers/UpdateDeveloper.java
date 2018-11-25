package JDBC.HomeWork.Cli.CommandHandler.DeveloperHandlers;

import JDBC.HomeWork.Cli.CommandHandler.CommandHandler;
import JDBC.HomeWork.Storage.DeveloperStorage;

/*
updateDeveloper first_name last_name age sex(male/female) companyId salary id
 */


public class UpdateDeveloper implements CommandHandler {

    @Override
    public void handleCommand(String[] parameters) {
        if (parameters.length == 7) {
            DeveloperStorage developerStorage = new DeveloperStorage();
            String name = parameters[0];
            String surname = parameters[1];
            String sex = parameters[3];
            long age = 0;
            long companyId = 0;
            long salary = 0;
            long id = 0;
            try {
                age = Long.parseLong(parameters[2]);
                companyId = Long.parseLong(parameters[4]);
                salary = Long.parseLong(parameters[5]);
                id = Long.parseLong(parameters[6]);
            } catch (NumberFormatException nf) {
                System.out.println("Неверный тип данных!");
                return;
            }

            developerStorage.updateDeveloper(name, surname, age, sex, companyId,salary,id);
        }else System.out.println("Неверное число параметров!");
    }
}
