package pl.kkowalczyk.bazaDanych;

public class Int_DbField implements IDbField {

    int val;

    public Int_DbField(String fieldValue) {
        val = Integer.valueOf(fieldValue);
    }

    @Override
    public DbFieldType getFieldType() {
        return DbFieldType.Int;
    }

    @Override
    public String getValue() {
        return String.valueOf(val);
    }
}

