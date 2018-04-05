package ru.sbt.jschool.session5.problem2;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Set;

public class ObjTypeArray implements Outputable {

    @Override
    public String stringValue(Object obj) throws IllegalAccessException {
        String result = "[";
        Object[] mas = (Object[]) obj;
        Outputable tmp = JsonObject.classMap.get(mas.getClass().getComponentType());
        if((tmp==null)&&(mas.getClass().getComponentType().isArray())) tmp = new ObjTypeArray();
        for (int i = 0; i < mas.length - 1; i++) {
                result = result + tmp.stringValue(mas[i]) + ",";
        }
        if(mas.length!=0) result = result + tmp.stringValue(mas[mas.length - 1]);
        result = result + "]";
        return result;
    }
}
