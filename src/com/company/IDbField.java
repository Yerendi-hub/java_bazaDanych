package com.company;

public interface IDbField {
     DbFieldType getFieldType();
     String getValue();
     Boolean create(Object a);
}

