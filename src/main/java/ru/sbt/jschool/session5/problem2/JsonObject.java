package ru.sbt.jschool.session5.problem2;

import com.sun.org.apache.xpath.internal.axes.OneStepIterator;

import java.lang.reflect.Field;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;


public class JsonObject {

    static public Map<Class<?>, Outputable> classMap = new HashMap<>();
    static {
        classMap.put(Object.class, new TypeSimple());

        classMap.put(Byte.class, new TypeSimple());
        classMap.put(Long.class, new TypeSimple());
        classMap.put(Short.class, new TypeSimple());
        classMap.put(Float.class, new TypeSimple());
        classMap.put(Double.class, new TypeSimple());
        classMap.put(Boolean.class, new TypeSimple());
        classMap.put(Integer.class, new TypeSimple());
        classMap.put(Character.class, new TypeSimple());

        classMap.put(int.class, new TypeSimple());
        classMap.put(long.class, new TypeSimple());
        classMap.put(char.class, new TypeSimple());
        classMap.put(byte.class, new TypeSimple());
        classMap.put(short.class, new TypeSimple());
        classMap.put(float.class, new TypeSimple());
        classMap.put(double.class, new TypeSimple());
        classMap.put(boolean.class, new TypeSimple());
        classMap.put(String.class, new TypeString());

        classMap.put(int[].class, new TypeArray());
        classMap.put(long[].class, new TypeArray());
        classMap.put(char[].class, new TypeArray());
        classMap.put(byte[].class, new TypeArray());
        classMap.put(short[].class, new TypeArray());
        classMap.put(float[].class, new TypeArray());
        classMap.put(double[].class, new TypeArray());
        classMap.put(boolean[].class, new TypeArray());

        classMap.put(Object[].class, new ObjTypeArray());

        classMap.put(SampleObject.class, new TypeJson());

        classMap.put(Date.class, new TypeDate());

        classMap.put(Set.class, new TypeSet());
    }

   public static String toJson(Object x) throws IllegalAccessException {
       Outputable tmp = JsonObject.classMap.get(x.getClass());
       if(x.getClass().isArray())
           tmp = new ObjTypeArray();
       return tmp.stringValue(x);
   }
}
