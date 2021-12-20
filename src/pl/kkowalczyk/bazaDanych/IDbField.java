package pl.kkowalczyk.bazaDanych;

public interface IDbField {
     DbFieldType getFieldType();
     String getValue();
     Boolean create(Object a);
}

