package pl.kkowalczyk.bazaDanych;

public class DbFieldDeclaration {
    private String name;
    private DbFieldType type;

    public DbFieldDeclaration(String _name, String _type)
    {
        name = _name;
        type = StringToFieldTypeParser(_type);
    }

    public String getName() {
        return name;
    }

    public DbFieldType getType() {
        return type;
    }

    private DbFieldType StringToFieldTypeParser(String val)
    {
        switch (val)
        {
            case "int":return DbFieldType.Int;
            case "string":return DbFieldType.String;
        }

        return DbFieldType.None;
    }
}
