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

    @Override
    public String updateValue(String newValue) {
        if(Utils.isNumeric(newValue))
        {
            val = Integer.valueOf(newValue);
            return "";
        }

        return String.format("Value %s is not int", newValue);
    }
}

