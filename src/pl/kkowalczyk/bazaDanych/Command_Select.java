package pl.kkowalczyk.bazaDanych;

public class Command_Select extends Command implements ICommand {

    public Command_Select() {
        super("select", "Allows to select rows from table.", "Usage: 'SELECT FROM table_name'");
    }

    @Override
    public String execute(String c) {
        try {
            String[] splitFrom = c.split(" from ");

            if(splitFrom.length < 2) return "Syntax: SELECT FROM table_name";

            String[] splitCommand = splitFrom[0].split(" ");
            String[] splitValue = splitFrom[1].split(" ");

            Table t = Engine.instance.getCurrentDatabase().getTable(splitValue[0]);

            if(t == null) return String.format("There is no table %s", splitValue[0]);

            StringBuilder sb = new StringBuilder();
            int fieldSize = 10;

            for (var field : t.getStructure())
            {
                String name = field.getName().length() > fieldSize-1 ? field.getName().substring(0,fieldSize-4) + "..." : field.getName();
                sb.append(String.format("%1$"+fieldSize+ "s", name));
            }

            sb.append("\n");

            for (var row : t.getRows())
            {
                for (var field : row.getFields())
                {
                    String val = field.getValue().length() > fieldSize-1 ? field.getValue().substring(0,fieldSize-4) + "..." : field.getValue();
                    sb.append(String.format("%1$"+fieldSize+ "s", val));
                }
                sb.append("\n");
            }

            return sb.toString();

        } catch (Exception e) {
            return String.format("Unsupported error when executing 'split' command: %s", e);
        }
    }
}
