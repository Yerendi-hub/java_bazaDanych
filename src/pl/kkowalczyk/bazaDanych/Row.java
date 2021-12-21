package pl.kkowalczyk.bazaDanych;

import java.util.ArrayList;
import java.util.List;

public class Row {
    private List<IDbField> fields;

    public Row()
    {
        fields = new ArrayList<>();
    }

    public String addField(DbFieldDeclaration declaration, String fieldValue)
    {
        IDbField field = null;

        switch (declaration.getType()) {
            case Int -> {
                field = new Int_DbField(fieldValue);
            }
            case String -> {
                field = new String_DbField(fieldValue);
            }
        }

        if(field != null)
        {
            fields.add(field);
            return "";
        }

        return "Tried to create field with unsupported type";
    }
}

