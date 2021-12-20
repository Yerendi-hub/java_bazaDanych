package pl.kkowalczyk.bazaDanych;

public class Command_Show extends Command implements ICommand {

    public Command_Show() {
        super("show", "allows to structures");
    }

    @Override
    public String execute(String c) {
        try
        {
            var split = c.split(" ");

            if (split[1].equals("databases")) {
                StringBuilder sb = new StringBuilder();

                for (var db : Engine.instance.getDatabases()) {
                    sb.append(db.getName()+ "\n");
                }

                return sb.toString();
            }
            else if (split[1].equals("tables")) {
                Database currentDatabase = Engine.instance.getCurrentDatabase();

                if(currentDatabase == null)
                {
                    return "There is no database selected. Type USE database_name command";
                }

                StringBuilder sb = new StringBuilder();

                for (var db : currentDatabase.getTables()) {
                    sb.append(db.getName() + "\n");
                }

                return sb.toString();
            }
            else{
                return "Unsupported type to be shown.";
            }
        }
        catch (Exception e)
        {
            return String.format("Unsupported error when executing 'show' command: %s", e);
        }
    }
}

