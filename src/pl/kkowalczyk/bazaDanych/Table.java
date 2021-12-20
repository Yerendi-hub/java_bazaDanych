package pl.kkowalczyk.bazaDanych;

import java.util.ArrayList;
import java.util.List;

public class Table {
    private List<DbFieldDeclaration> structure;
    private List<Row> rows;
    private String name;

    public String getName()
    {
        return name;
    }

    public Table(String _name, List<DbFieldDeclaration> fields)
    {
        name = _name;
        structure = fields;
        rows = new ArrayList<Row>();
    }
}

