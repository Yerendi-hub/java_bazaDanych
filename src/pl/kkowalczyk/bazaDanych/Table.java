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
    public List<Row> getRows() { return rows; }
    public List<DbFieldDeclaration> getStructure() { return structure; }

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

    public String deleteRow(String id)
    {
        Row row = rows.stream()
                .filter(d -> id.equals(d.getId()))
                .findAny()
                .orElse(null);

        if(row == null) return String.format("There is no row with id %s", id);

        rows.remove(row);
        return String.format("Row with id %s deleted.", id);
    }

    public String updateRow(String id, ArrayList<String> values)
    {
        Row row = rows.stream()
                .filter(d -> id.equals(d.getId()))
                .findAny()
                .orElse(null);

        if(row == null) return String.format("There is no row with id %s", id);

        if(values.size() != row.getFields().size()-1) return String.format("Values count does not match with row values count");

        for (int i = 0; i < values.size(); i++)
        {
            String updateStatus = row.getFields().get(i+1).updateValue(values.get(i));

            if(!updateStatus.equals("")) return updateStatus;
        }

        return String.format("Row with id %s updated.", id);
    }
}

