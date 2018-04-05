package ru.sbt.jschool.session5.problem2;

import com.google.gson.Gson;

import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;


public class Test {
    public static void main(String[] args) throws Exception {

        SampleObject x = new SampleObject();
        x.setX(5);
        x.name = "NAME";
        x.mas = new int[]{1, 2, 3};
        x.mas1 = new Integer[]{1, 2, 3};
        x.strings = new String[]{"SDFG","SDFGHJ","ANDREAS"};
        x.xx = 6;
        x.matrix = new int[][]{{1,2,3},{2,3,4},{5},{6},{7,6,4,132,1}};
        x.matrix2 = new Integer[][]{{1,2,3},{2,3,4},{5},{6},{7,6,4,132,1}};
        x.charmas = new char[]{'a','b','c','d'};
        x.date = new Date();
        x.setInt = new HashSet<>();
        x.setInt.add(1);
        x.setInt.add(2);
        x.setInt.add(3);
        System.out.println(JsonObject.toJson(x));
        Gson gson = new Gson();
        String jsonString = gson.toJson(x);
        System.out.println(jsonString);
    }
}
