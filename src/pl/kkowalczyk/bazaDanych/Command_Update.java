package pl.kkowalczyk.bazaDanych;

import java.util.ArrayList;

public class Command_Update extends Command implements ICommand {

    public Command_Update() {
        super("update", "Allows to update row values.", "Usage: 'UPDATE table_name id val1 val2 ...");
    }

    @Override
    public String execute(String c) {
        try {
            var split = c.split(" ");

            if (split.length > 4) {

                Table table = Engine.instance.getCurrentDatabase().getTable(split[1]);

                if (table == null) return String.format("There is no table %s", split[1]);

                ArrayList<String> values = new ArrayList<>();

                for (int i = 3; i < split.length; i++)
                {
                    values.add(split[i]);
                }

                return table.updateRow(split[2],values);

            } else {
                return "Usage: 'UPDATE table_name id val1 val2 ...";
            }
        } catch (Exception e) {
            return String.format("Unsupported error when executing 'show' command: %s", e);
        }
    }
}
