package pl.kkowalczyk.bazaDanych;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Database {
    private String name;
    private List<Table> tables;

    public Database(String _name)
    {
        name = _name;
        tables = new ArrayList<Table>();
    }

    public List<Table> getTables()
    {
        return tables;
    }

    public String getName() {
        return name;
    }

    public void setName(String newName) {
        name = newName;
    }

    public String createTable(Table table) {
        try
        {
            if(!Utils.isNameLegal(table.getName())) return String.format("Name %s is forbidden.", table.getName());

            if(!tables.stream().filter(o -> o.getName().equals(table.getName())).findFirst().isPresent())
            {
                HashSet<String> names = new HashSet<>();

                for (var field : table.getStructure())
                {
                    if(!names.add(field.getName()))
                    {
                        return String.format("Table %s has duplicated column names: %s.", table.getName(), field.getName());
                    }
                }

                tables.add(table);
                return String.format("Table %s created successfully.", table.getName());
            }
            else
            {
                return String.format("Table with name %s already exist.", table.getName());
            }
        }
        catch (Exception e)
        {
            return String.format("Unsupported error when creating table: %s", e);
        }
    }

    public Table getTable(String tableName)
    {
        Table table = tables.stream()
                .filter(d -> tableName.equals(d.getName()))
                .findAny()
                .orElse(null);

        return table;
    }
}

