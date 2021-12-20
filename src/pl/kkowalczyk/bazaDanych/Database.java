package pl.kkowalczyk.bazaDanych;

import com.company.dbExceptions.DatabaseAlreadyExistException;

import java.util.ArrayList;
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
            if(!tables.stream().filter(o -> o.getName().equals(table.getName())).findFirst().isPresent())
            {
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
}

