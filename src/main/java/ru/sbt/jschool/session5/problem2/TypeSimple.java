package ru.sbt.jschool.session5.problem2;

import java.lang.reflect.Field;

public class TypeSimple implements Outputable {
    @Override
    public String stringValue(Object obj) throws IllegalAccessException {
        return  obj.toString();
    }
}
