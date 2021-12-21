package pl.kkowalczyk.bazaDanych;

public class Command_Quit extends Command implements ICommand {

    public Command_Quit() {
        super("quit", "exits program", "Usage: QUIT");
    }

    @Override
    public String execute(String c) {
        System.exit(0);
        return "Bye.";
    }
}
