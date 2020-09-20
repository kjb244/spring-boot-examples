package com.boot.utils;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Utilities {

    public static void merge(Object a, Object b, String... skip) {
        Class<?> aClazz = a.getClass();
        Class<?> bClazz = b.getClass();
        if (aClazz.getName() != bClazz.getName()) {
            return;
        }
        List<String> skipParms = new ArrayList<>();
        if(null != skip){
            skipParms = Arrays.asList(skip)
                    .stream()
                    .map(r -> r.toLowerCase()).collect(Collectors.toList());
        }
        List<Field> aFields = Arrays.asList(aClazz.getDeclaredFields());
        List<Field> bFields = Arrays.asList(bClazz.getDeclaredFields());

        int cntr = 0;
        for (Field field : bFields) {
            field.setAccessible(true);
            if(skipParms.contains(field.getName())){
                continue;
            }
            try {
                if (null != field.get(b)) {
                    Object bObjectValue = field.get(b);
                    Field fieldA = aFields.get(cntr);
                    fieldA.setAccessible(true);
                    fieldA.set(a, bObjectValue);
                }
                cntr++;
            } catch (Exception e) {
                System.out.println(e.toString());
            }
        }
    }

}
