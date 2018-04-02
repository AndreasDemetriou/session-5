package ru.sbt.jschool.session5.problem1;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;


/**
 */
public class SQLGenerator {
    private String writerPK(Field[] fields, Class<? extends Annotation> x, String separator, boolean flag) {
        String result = "";
        int counter = 0;
        for (int i = 0; i < fields.length; i++) {
            Field f = fields[i];
            Annotation a = f.getAnnotation(x);
            if ((a != null) && (counter != 0)) {
                result = result + separator;
            }
            if (a != null) {
                counter++;
                String tmp = "";
                if (x.equals(PrimaryKey.class)) {
                    if (!f.getAnnotation(PrimaryKey.class).name().equals("")) {
                        tmp = f.getAnnotation(PrimaryKey.class).name().toLowerCase();
                    } else {
                        tmp = f.getName().toLowerCase();
                    }
                }
                if (x.equals(Column.class)){
                    if (!f.getAnnotation(Column.class).name().equals("")) {
                        tmp = f.getAnnotation(Column.class).name().toLowerCase();
                    } else {
                        tmp = f.getName().toLowerCase();
                    }
                }
                if (flag) result = result + tmp + " = ?";
                else result = result + tmp;
            }
        }
        return result;
    }

    public <T> String insert(Class<T> clazz) {
        int annCounter = 0;
        String result = "INSERT INTO ";
        result = result + clazz.getAnnotation(Table.class).name() + "(";
        Field[] fields = clazz.getDeclaredFields();
        for (int i = 0; i < fields.length; i++) {
            Field f = fields[i];
            Annotation a = f.getAnnotation(Column.class);
            Annotation b = f.getAnnotation(PrimaryKey.class);
            String x = "";
            if(((a != null) || (b != null)) && (annCounter != 0)) {
                result = result + ", ";
            }
            if (a != null) {
                annCounter++;
                if (!f.getAnnotation(Column.class).name().equals("")) {
                    x = f.getAnnotation(Column.class).name().toLowerCase();
                }
                else{
                    x = f.getName().toLowerCase();
                }
            }
            if (b != null) {
                annCounter++;
                if (!f.getAnnotation(PrimaryKey.class).name().equals("")) {
                    x = f.getAnnotation(PrimaryKey.class).name().toLowerCase();
                } else {
                    x = f.getName().toLowerCase();
                }
            }
            result = result + x;
        }
        result = result + ")";
        result = result + " VALUES (";
        for (int i = 0; i < annCounter - 1; i++) {
            result = result + "?, ";
        }
        result = result + "?)";
        return result;
    }

    public <T> String update(Class<T> clazz) {
        String result = "UPDATE ";
        result = result + clazz.getAnnotation(Table.class).name() + " SET ";
        Field[] fields = clazz.getDeclaredFields();
        result = result + writerPK(fields, Column.class, ", ", true);
        result = result + " WHERE ";
        result = result + writerPK(fields, PrimaryKey.class, " AND ", true);
        return result;
    }

    public <T> String delete(Class<T> clazz) {
        String result = "DELETE FROM ";
        result = result + clazz.getAnnotation(Table.class).name() + " WHERE ";
        Field[] fields = clazz.getDeclaredFields();
        result = result + writerPK(fields, PrimaryKey.class, " AND ", true);
        return result;
    }

    public <T> String select(Class<T> clazz) {
        String result = "SELECT ";
        Field[] fields = clazz.getDeclaredFields();
        result = result + writerPK(fields, Column.class, ", ", false);
        result = result + " FROM ";
        result = result + clazz.getAnnotation(Table.class).name() + " WHERE ";
        result = result + writerPK(fields, PrimaryKey.class, " AND ", true);
        return result;
    }

}
