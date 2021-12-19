package com.company;

import java.util.ArrayList;

public class Command_Create extends Command implements ICommand {

    public Command_Create()
    {
        super("create", "allows to create structures");
    }

    @Override
    public String execute(String c) {
        try
        {
            var split = c.split(" ");

            if(split[1].equals("database"))
            {
               return handleDatabaseCreation(split);
            }
            else if(split[1].equals("table"))
            {
                return handleTableCreation(split);
            }
            else{
                return String.format("Unsupported structure %s", split[1]);
            }
        }
        catch (Exception e)
        {
            return String.format("Unsupported error when executing 'create' command: %s", e);
        }
    }

    private String handleDatabaseCreation(String[] command)
    {
        if(command.length > 2)
        {
            return Engine.instance.createDatabase(command[2]);
        }
        else
        {
            return "You have to type database name in order to create database.";
        }
    }

    private String handleTableCreation(String[] command)
    {
        if(Engine.instance.getCurrentDatabase() == null)
        {
            return "There is no database selected. Type USE database_name command";
        }

        if(command.length > 2)
        {
            if(command.length % 2 != 0) {
                String name = command[2];
                ArrayList<DbFieldDeclaration> fields = new ArrayList<>();

                for (int i = 3; i < command.length; i += 2)
                {
                    fields.add(new DbFieldDeclaration(command[i], command[i+1]));
                }

                return Engine.instance.getCurrentDatabase().createTable(new Table(name, fields));
            }
            else
            {
                return "Numbers of elements in creation statement must match.";
            }
        }
        else
        {
            return "You have to type database name in order to create database.";
        }
    }
}

