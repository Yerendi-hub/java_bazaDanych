package pl.kkowalczyk.bazaDanych;

public interface IDbField {
     DbFieldType getFieldType();
     String getValue();
     String updateValue(String newValue);
}

