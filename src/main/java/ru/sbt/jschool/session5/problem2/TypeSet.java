package ru.sbt.jschool.session5.problem2;

import java.util.Set;

public class TypeSet implements Outputable {
    @Override
    public String stringValue(Object obj) throws IllegalAccessException {
        Set<Object> set = (Set<Object>) obj;
        Object[] mas = set.toArray();
        return JsonObject.toJson(mas);//JsonObject.toJson(mas);
    }
}
