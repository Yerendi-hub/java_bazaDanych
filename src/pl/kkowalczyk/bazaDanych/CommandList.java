package pl.kkowalczyk.bazaDanych;

import java.util.ArrayList;
import java.util.List;

public class CommandList {
    private List<ICommand> commands;

    public List<ICommand> getCommands() {return commands;}

    public CommandList()
    {
        commands = new ArrayList<ICommand>();
        commands.add(new Command_Create());
        commands.add(new Command_Quit());
        commands.add(new Command_Show());
        commands.add(new Command_Use());
        commands.add(new Command_Insert());
        commands.add(new Command_Help());
        commands.add(new Command_Select());
        commands.add(new Command_Delete());
        commands.add(new Command_Update());
    }

    public String execute(String c)
    {
        String[] split = c.split(" ");

        if(split.length > 0)
        {
            ICommand command = getCommand(split[0]);

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

    public ICommand getCommand(String commandName)
    {
        ICommand command = commands.stream()
                .filter(d -> commandName.equals(d.getName()))
                .findAny()
                .orElse(null);
        return command;
    }
}
