package ru.sbt.jschool.session5.problem1;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

/**
 */
public class SQLGenerator {
    private String WriterPK (Field[] fields){
        String result = "";
        int pkCounter = 0;
        for (int i = 0; i <fields.length ; i++){
            Field f = fields[i];
            Annotation a = f.getAnnotation(PrimaryKey.class);
            if((a!=null)&&(pkCounter!=0))
            {
                result = result + " AND ";
            }
            if(a!=null){
                pkCounter++;
                String tmp;
                if(!f.getAnnotation(PrimaryKey.class).name().equals("")) {
                    tmp = f.getAnnotation(PrimaryKey.class).name().toLowerCase();
                }
                else{
                    tmp = f.getName().toLowerCase();
                }
                result = result + tmp + " = ?";
            }
        }
        return result;
    }

    public <T> String insert(Class<T> clazz) {
        int annCounter = 0;
        String result = "INSERT INTO ";
        result = result + clazz.getAnnotation(Table.class).name()+"(";
        Field[] fields = clazz.getDeclaredFields();
        for (int i = 0; i <fields.length ; i++){
            Field f = fields[i];
            Annotation a = f.getAnnotation(Column.class);
            Annotation b = f.getAnnotation(PrimaryKey.class);
            String x = "";
            if(((a!=null)||(b!=null))&&(annCounter!=0))
            {
                    result = result + ", ";
            }
            if(a!=null){
                annCounter++;
                if(!f.getAnnotation(Column.class).name().equals("")) {
                    x = f.getAnnotation(Column.class).name().toLowerCase();
                }
                else{
                    x = f.getName().toLowerCase();
                }
            }
            if(b!=null){
                annCounter++;
                if(!f.getAnnotation(PrimaryKey.class).name().equals("")) {
                    x = f.getAnnotation(PrimaryKey.class).name().toLowerCase();
                }
                else{
                    x = f.getName().toLowerCase();
                }
            }
            result = result + x;
        }
        result = result + ")";
        result = result + " VALUES (";
        for (int i = 0; i < annCounter-1; i++) {
            result = result + "?, ";
        }
        result = result + "?)";
        return result;
    }

    public <T> String update(Class<T> clazz) {
        String result = "UPDATE ";
        result = result + clazz.getAnnotation(Table.class).name()+" SET ";
        Field[] fields = clazz.getDeclaredFields();
        int colCounter = 0;
        for (int i = 0; i <fields.length ; i++){
            Field f = fields[i];
            Annotation a = f.getAnnotation(Column.class);
            if((a!=null)&&(colCounter!=0))
            {
                result = result + ", ";
            }
            if(a!=null){
                colCounter++;
                String tmp;
                if(!f.getAnnotation(Column.class).name().equals("")) {
                    tmp = f.getAnnotation(Column.class).name().toLowerCase();
                }
                else{
                    tmp = f.getName().toLowerCase();
                }
                result = result + tmp + " = ?";
            }
        }
        result = result + " WHERE ";
        result = result + WriterPK(fields);
        return result;
    }

    public <T> String delete(Class<T> clazz) {
        String result = "DELETE FROM ";
        result = result + clazz.getAnnotation(Table.class).name()+" WHERE ";
        Field[] fields = clazz.getDeclaredFields();
        result = result + WriterPK(fields);
        return result;
    }

    public <T> String select(Class<T> clazz) {
        String result = "SELECT ";
        Field[] fields = clazz.getDeclaredFields();
        int colCounter = 0;
        for (int i = 0; i <fields.length ; i++){
            Field f = fields[i];
            Annotation a = f.getAnnotation(Column.class);
            if((a!=null)&&(colCounter!=0))
            {
                result = result + ", ";
            }
            if(a!=null){
                colCounter++;
                String tmp;
                if(!f.getAnnotation(Column.class).name().equals("")) {
                    tmp = f.getAnnotation(Column.class).name().toLowerCase();
                }
                else{
                    tmp = f.getName().toLowerCase();
                }
                result = result + tmp;
            }
        }
        result = result + " FROM ";
        result = result + clazz.getAnnotation(Table.class).name()+" WHERE ";
        result = result + WriterPK(fields);
        return result;
    }

}
