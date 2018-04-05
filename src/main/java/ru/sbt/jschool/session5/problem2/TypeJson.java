package ru.sbt.jschool.session5.problem2;

import java.lang.reflect.Field;
import java.util.Set;

public class TypeJson implements Outputable {
    @Override
    public String stringValue(Object obj) throws IllegalAccessException {
        String result = "{";
        Field[] fields= obj.getClass().getDeclaredFields();
        String[] content = new String[fields.length];
        int i = 0;
        Set<Class<?>> classSet = JsonObject.classMap.keySet();
        for (Field f: fields
                ) {
            f.setAccessible(true);
            Outputable tmp = JsonObject.classMap.get(f.getType());
            if((tmp == null)&&(f.getType().isArray())) tmp = new ObjTypeArray();
            if(tmp!=null) {
                content[i] = "\"" + f.getName() + "\":";
                content[i] = content[i] + tmp.stringValue(f.get(obj));
            }else content[i] = "NOT SUPPORTED";//content[i] = new JsonObject(f.get(obj)).JSON;//"NOT";
            i++;
        }
        for (int j = 0; j < content.length-1; j++) {
            result = result + content[j] + ",";
        }
        if(content.length!=0) result = result + content[content.length - 1];
        result = result + "}";
        return result;
    }
}
