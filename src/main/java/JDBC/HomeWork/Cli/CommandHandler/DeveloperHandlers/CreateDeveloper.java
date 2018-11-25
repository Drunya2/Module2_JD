package JDBC.HomeWork.Cli.CommandHandler.DeveloperHandlers;

import JDBC.HomeWork.Cli.CommandHandler.CommandHandler;
import JDBC.HomeWork.Storage.DeveloperStorage;

/*
createDeveloper first_name last_name age sex(male/female) companyId salary
 */

public class CreateDeveloper implements CommandHandler {

    @Override
    public void handleCommand(String[] parameters) {
        if (parameters.length == 6) {
            DeveloperStorage developerStorage = new DeveloperStorage();
            String name = parameters[0];
            String surname = parameters[1];
            String sex = parameters[3];
            long age = 0;
            long companyId = 0;
            long salary = 0;
            try {
                age = Long.parseLong(parameters[2]);
                companyId = Long.parseLong(parameters[4]);
                salary = Long.parseLong(parameters[5]);
            } catch (NumberFormatException nf) {
                System.out.println("Неверный тип данных!");
                return;
            }
            developerStorage.createDeveloper(name, surname, age, sex, companyId, salary);
        }else System.out.println("Неверное число параметров!");
    }
}
