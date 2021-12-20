package pl.kkowalczyk.bazaDanych;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Engine {
    public static Engine instance;

    private List<Database> databases;
    private Database currentDatabase;
    private CommandList commandList;

    public Engine()
    {
        commandList = new CommandList();
        instance = this;
        databases = new ArrayList<Database>();
    }

    public List<Database> getDatabases()
    {
        return databases;
    }

    public void executeEngineLoop() {
        Scanner in = new Scanner(System.in);

        while (true)
        {
            System.out.print("\nsdb>");
            String c = in.nextLine();
            String result = commandList.execute(c);
            System.out.print(result);
        }
    }

    public String createDatabase(String databaseName)
    {
        try
        {
            if(!databases.stream().filter(o -> o.getName().equals(databaseName)).findFirst().isPresent())
            {
                databases.add(new Database(databaseName));
                return String.format("Database %s created successfully.", databaseName);
            }
            else
            {
                return String.format("Database with name %s already exist.", databaseName);
            }
        }
        catch (Exception e)
        {
            return String.format("Unsupported error when creating database: %s", e);
        }
    }

    public Database getCurrentDatabase() {
        return currentDatabase;
    }

    public String selectDefaultDatabase(String dbName)
    {
        Database db = databases.stream()
                .filter(d -> dbName.equals(d.getName()))
                .findAny()
                .orElse(null);

        if(db != null)
        {
            currentDatabase = db;
            return String.format("Current database successfully set as '%s'", dbName);
        }
        else{
            return String.format("Database with name '%s' does not exist", dbName);
        }
    }
}
