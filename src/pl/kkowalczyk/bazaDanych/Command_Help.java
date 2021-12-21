package pl.kkowalczyk.bazaDanych;

import java.util.Locale;

public class Command_Help extends Command implements ICommand {

    public Command_Help() {
        super("help", "Shows commands with description. Type 'HELP command_name' to get detailed description",
                "Type HELP command_name to get detailed description");
    }

    @Override
    public String execute(String c) {

        String[] split = c.split(" ");

        if (split.length == 1) {
            StringBuilder sb = new StringBuilder();

            for (var command : Engine.instance.getCommandList().getCommands()) {
                sb.append(String.format("%s: %s\n", command.getName().toUpperCase(Locale.ROOT), command.getDescription()));
            }

            return sb.toString();
        } else {
            ICommand command = Engine.instance.getCommandList().getCommand(split[1]);
            if (command != null) {
                return command.getDetailedDescription();
            } else {
                return String.format("There is no command '%s'", split[1]);
            }
        }

    }
}
