package ru.sbt.jschool.session5.problem2;

import java.lang.reflect.Field;

public class TypeArray implements Outputable {
    @Override
    public String stringValue(Object obj) throws IllegalAccessException {
        String result = "[";
        if(obj.getClass().getComponentType().equals(int.class)) {
            int[] mas = (int[]) obj;
            for (int i = 0; i < mas.length - 1; i++) {
                result = result + mas[i] + ",";
            }
            if (mas.length != 0) result = result + mas[mas.length - 1];
        }
        if(obj.getClass().getComponentType().equals(long.class)) {
            long[] mas = (long[]) obj;
            for (int i = 0; i < mas.length - 1; i++) {
                result = result + mas[i] + ",";
            }
            if (mas.length != 0) result = result + mas[mas.length - 1];
        }
        if(obj.getClass().getComponentType().equals(char.class)) {
            char[] mas = (char[]) obj;
            for (int i = 0; i < mas.length - 1; i++) {
                result = result + mas[i] + ",";
            }
            if (mas.length != 0) result = result + mas[mas.length - 1];
        }
        if(obj.getClass().getComponentType().equals(byte.class)) {
            byte[] mas = (byte[]) obj;
            for (int i = 0; i < mas.length - 1; i++) {
                result = result + mas[i] + ",";
            }
            if (mas.length != 0) result = result + mas[mas.length - 1];
        }
        if(obj.getClass().getComponentType().equals(short.class)) {
            short[] mas = (short[]) obj;
            for (int i = 0; i < mas.length - 1; i++) {
                result = result + mas[i] + ",";
            }
            if (mas.length != 0) result = result + mas[mas.length - 1];
        }
        if(obj.getClass().getComponentType().equals(double.class)) {
            double[] mas = (double[]) obj;
            for (int i = 0; i < mas.length - 1; i++) {
                result = result + mas[i] + ",";
            }
            if (mas.length != 0) result = result + mas[mas.length - 1];
        }
        if(obj.getClass().getComponentType().equals(float.class)) {
            float[] mas = (float[]) obj;
            for (int i = 0; i < mas.length - 1; i++) {
                result = result + mas[i] + ",";
            }
            if (mas.length != 0) result = result + mas[mas.length - 1];
        }
        if(obj.getClass().getComponentType().equals(boolean.class)) {
            boolean[] mas = (boolean[]) obj;
            for (int i = 0; i < mas.length - 1; i++) {
                result = result + mas[i] + ",";
            }
            if (mas.length != 0) result = result + mas[mas.length - 1];
        }
        result = result + "]";
        return result;
    }
}


/*


    int[] mas = (int[]) obj;
            for (int i = 0; i < mas.length - 1; i++) {
        result = result + mas[i] + ",";
        }
        if (mas.length != 0) result = result + mas[mas.length - 1];


*/