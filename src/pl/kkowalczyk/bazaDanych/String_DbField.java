package pl.kkowalczyk.bazaDanych;

public class String_DbField implements IDbField {

    String val;

    public String_DbField(String fieldValue) {
        val = fieldValue;
    }

    @Override
    public DbFieldType getFieldType() {
        return DbFieldType.String;
    }

    @Override
    public String getValue() {
        return val;
    }
}
