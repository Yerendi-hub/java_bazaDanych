package com.company;

import java.util.Locale;

public abstract class Command implements ICommand {
    protected String name;
    protected String description;

    public Command(String _name, String _description)
    {
        name = _name.toLowerCase();
        description = _description.toLowerCase();
    }

    public String getName()
    {
        return name;
    }

    public String getDescription()
    {
        return description;
    }
}


