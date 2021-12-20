package pl.kkowalczyk.bazaDanych;

public class Int_DbField implements IDbField {

    int val;

    @Override
    public DbFieldType getFieldType() {
        return DbFieldType.Int;
    }

    @Override
    public String getValue() {
        return String.valueOf(val);
    }

    @Override
    public Boolean create(Object a) {
        return null;
    }
}

