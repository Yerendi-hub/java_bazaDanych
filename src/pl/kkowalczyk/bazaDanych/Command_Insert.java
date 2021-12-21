package pl.kkowalczyk.bazaDanych;

import java.util.ArrayList;
import java.util.List;

public class Command_Insert extends Command implements ICommand {

    public Command_Insert() {
        super("insert", "allows to insert data to database.", "");
    }

    @Override
    public String execute(String c) {
        String[] split = c.split(" ");

        if(split.length < 4 || !split[1].equals("into")) return "'INSERT' syntax is 'INSERT INTO table_name val1 val2 val3...'";
        if(Engine.instance.getCurrentDatabase() == null) return "There is no database selected. Type USE database_name command";

        Table table = Engine.instance.getCurrentDatabase().getTable(split[2]);
        if(table == null) return String.format("There is no table with name %s", split[2]);

        ArrayList<String> values = new ArrayList<String>();

        for (int i = 3; i < split.length; i++)
        {
            values.add(split[i]);
        }

        return table.insert(values);
    }
}