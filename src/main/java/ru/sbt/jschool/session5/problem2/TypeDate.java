package ru.sbt.jschool.session5.problem2;

import java.text.SimpleDateFormat;

public class TypeDate implements Outputable {
    private SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");

    @Override
    public String stringValue(Object obj) throws IllegalAccessException {
        return dateFormat.format(obj);
    }
}
