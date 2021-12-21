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

    public boolean doesValueMatchType(String val)
    {
        if(val == null) return false;

        switch (type) {
            case Int -> {
                return Utils.isNumeric(val);
            }
            case String -> {
                return true;
            }
            default ->{
                return false;
            }
        }
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

