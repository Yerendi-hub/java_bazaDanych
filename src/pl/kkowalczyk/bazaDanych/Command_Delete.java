package pl.kkowalczyk.bazaDanych;

public class Command_Delete extends Command implements ICommand {

    public Command_Delete() {
        super("delete", "Allows to delete rows in table.", "Usage: 'DELETE FROM table_name id");
    }

    @Override
    public String execute(String c) {
        try {
            var split = c.split(" ");

            if (split.length > 3) {

                Table table = Engine.instance.getCurrentDatabase().getTable(split[2]);

                if(table == null) return String.format("There is no table %s", split[2]);

                return table.deleteRow(split[3]);

            } else {
                return "Usage: 'DELETE FROM table_name WHERE field='value'";
            }
        } catch (Exception e) {
            return String.format("Unsupported error when executing 'show' command: %s", e);
        }
    }
}

