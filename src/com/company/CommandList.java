package com.company;

import java.util.ArrayList;
import java.util.List;

public class CommandList {
    List<ICommand> commands;

    public CommandList()
    {
        commands = new ArrayList<ICommand>();
        commands.add(new Command_Create());
        commands.add(new Command_Quit());
        commands.add(new Command_Show());
        commands.add(new Command_Use());
    }

    public String execute(String c)
    {
        String[] split = c.split(" ");

        if(split.length > 0)
        {
            ICommand command = commands.stream()
                    .filter(d -> split[0].equals(d.getName()))
                    .findAny()
                    .orElse(null);

            if(command != null)
            {
                return command.execute(c);
            }
            else{
                return String.format("Command '%s' is not supported.", split[0]);
            }
        }
        else{
            return "";
        }
    }
}
