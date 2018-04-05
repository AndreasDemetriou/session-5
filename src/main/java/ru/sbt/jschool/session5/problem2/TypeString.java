package ru.sbt.jschool.session5.problem2;

import java.lang.reflect.Field;

public class TypeString implements Outputable{

    @Override
    public String stringValue(Object obj) throws IllegalAccessException {
        String result = "\"" + obj + "\"";
        return result;
    }
}
