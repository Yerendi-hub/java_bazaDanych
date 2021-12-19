package com.company;

public class Command_Use extends Command implements ICommand {

    public Command_Use() {
        super("use", "Allows to select default database. Usage: 'use my_db_name'");
    }

    @Override
    public String execute(String c) {
        try {
            var split = c.split(" ");

            if(split.length > 1)
            {
              return Engine.instance.selectDefaultDatabase(split[1]);
            }
            else{
                return "You have to specify db name";
            }
        } catch (Exception e) {
            return String.format("Unsupported error when executing 'show' command: %s", e);
        }
    }
}
