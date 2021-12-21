package pl.kkowalczyk.bazaDanych;

public abstract class Command implements ICommand {
    protected String name;
    protected String description;
    protected String detailedDescription;

    public Command(String _name, String _description, String _detailedDescription)
    {
        name = _name.toLowerCase();
        description = _description;
        detailedDescription = _detailedDescription;
    }

    public String getName()
    {
        return name;
    }

    public String getDescription()
    {
        return description;
    }
    public String getDetailedDescription()    {        return detailedDescription;    }
}


