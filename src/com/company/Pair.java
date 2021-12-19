package com.company;

public class Pair<T, U> {

    private T item1;
    private U item2;

    public Pair(T i1, U i2)
    {
        item1 = i1;
        item2 = i2;
    }

    public T getItem1() {
        return item1;
    }

    public U getItem2() {
        return item2;
    }
}
