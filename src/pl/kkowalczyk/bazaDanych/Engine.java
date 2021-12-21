package pl.kkowalczyk.bazaDanych;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
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
    public CommandList getCommandList() {return commandList;}

    public void executeEngineLoop() {
        initSimpleDb();
        System.out.println("Welcome in java db simulation. Type 'HELP' to list avaliable commands. \n There is simple database 'db' pre-initialized" );
        Scanner in = new Scanner(System.in);

        while (true)
        {
            System.out.print("\n>");
            String c = in.nextLine();
            String result = commandList.execute(c.toLowerCase());
            System.out.print(result);
        }
    }

    public String createDatabase(String databaseName)
    {
        try
        {
            if(!Utils.isNameLegal(databaseName)) return String.format("Name %s is forbidden.", databaseName);

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

    private void initSimpleDb()
    {
        commandList.execute("create database db");
        commandList.execute("use db");
        commandList.execute("create table t k1 int k2 string");
        commandList.execute("insert into t 123 asd");
        commandList.execute("insert into t 234 sdf");
        commandList.execute("insert into t 345 dfgaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
    }
}
