package pl.kkowalczyk.bazaDanych;

import java.util.ArrayList;
import java.util.List;

public class Table {
    private List<DbFieldDeclaration> structure;
    private List<Row> rows;
    private String name;
    private int pk = 1;

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

    public String insert(ArrayList<String> values)
    {
        if(values.size() < structure.size() -1)return "Too few parameters";
        if(values.size() > structure.size() -1)return "Too many parameters";

        for (int i = 1; i < structure.size(); i++)
        {
            if(!structure.get(i).doesValueMatchType(values.get(i-1)))
            {
                return String.format("value %d has wrong type - should be %s", i-1, structure.get(i).getType().toString());
            }
        }

        Row row = new Row();
        row.addField(structure.get(0), Integer.toString(pk));

        for (int i = 1; i < structure.size(); i++)
        {
            if(!structure.get(i).doesValueMatchType(values.get(i-1)))
            {
                return String.format("value %d has wrong type - should be %s", i-1, structure.get(i).getType().toString());
            }

            String added = row.addField(structure.get(i), values.get(i-1));

            if(!added.equals("")) return added;
        }

        pk++;
        rows.add(row);
        return "Row added";
    }
}

