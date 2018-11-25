package JDBC.HomeWork.Cli;

import JDBC.HomeWork.Cli.CommandHandler.*;
import JDBC.HomeWork.Cli.CommandHandler.CompanyHandler.*;
import JDBC.HomeWork.Cli.CommandHandler.CustomerHandler.*;
import JDBC.HomeWork.Cli.CommandHandler.DeveloperHandlers.*;
import JDBC.HomeWork.Cli.CommandHandler.ProjectHandlers.*;
import JDBC.HomeWork.Cli.CommandHandler.SkillHandlers.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    private static String command;
    private static String[] parameters;
    private static boolean isEnd = false;
    private static Map<String, CommandHandler> commands;

    private static void readCommand() {
        String line;
        Scanner scanner = new Scanner(System.in);
        line = scanner.nextLine();
        String[] array = line.split(" ");
        command = array[0];
        parameters = new String[array.length - 1];
        for (int i = 1; i < array.length; i++) {
            parameters[i - 1] = array[i];
        }
    }

    private static void handleCommand() {
        while (isEnd != true) {
            readCommand();
            if (command.equals("exit")) {
                isEnd = true;
                return;
            }

            if (!commands.containsKey(command)) {
                System.out.println("Unknown comamnd: " + command);
                return;
            }
            commands.get(command).handleCommand(parameters);
        }
    }

    static void initCommands() {
        commands = new HashMap<>();
        commands.put("createDeveloper", new CreateDeveloper());
        commands.put("deleteDeveloper", new DeleteDeveloper());
        commands.put("updateDeveloper", new UpdateDeveloper());
        commands.put("getDeveloper", new GetDeveloper());
        commands.put("getListDevelopers", new GetListDevelopers());
        commands.put("createSkill", new CreateSkill());
        commands.put("deleteSkill", new DeleteSkill());
        commands.put("updateSkill", new UpdateSkill());
        commands.put("getSkill", new GetSkill());
        commands.put("getListSkills", new GetListSkills());
        commands.put("createProject", new CreateProject());
        commands.put("deleteProject", new DeleteProject());
        commands.put("updateProject", new UpdateProject());
        commands.put("getProject", new GetProject());
        commands.put("getListProjects", new GetListProjects());
        commands.put("createCompany", new CreateCompany());
        commands.put("deleteCompany", new DeleteCompany());
        commands.put("updateCompany", new UpdateCompany());
        commands.put("getCompany", new GetCompany());
        commands.put("getListCompanies", new GetListCompanies());
        commands.put("createCustomer", new CreateCustomer());
        commands.put("updateCustomer", new UpdateCustomer());
        commands.put("deleteCustomer", new DeleteCustomer());
        commands.put("getCustomer", new GetCustomer());
        commands.put("getListCustomers", new GetListCustomers());
        commands.put("getSumSalary", new GetSumSalary());
        commands.put("getDevelopersByProject", new GetDevelopersByProject());
        commands.put("getAllJavaDevelopers", new GetAllJavaDevelopers());
        commands.put("getAllMiddleDevelopers", new GetAllMiddleDevelopers());
        commands.put("getProjects", new GetProjects());
    }


    public static void main(String[] args) {
        initCommands();
        while (!isEnd) {
            handleCommand();
        }
    }
}
