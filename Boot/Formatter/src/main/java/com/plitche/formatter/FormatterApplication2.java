package com.plitche.formatter;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.boot.SpringApplication;

public class FormatterApplication2 {

    // ./gradlew spotlessCheck
    // ./gradlew spotlessApply

    public static void main(String[] args) {
        SpringApplication.run(FormatterApplication2.class, args);

        int[] intArray = new int[5];
        intArray[0] = 1;
        intArray[1] = 2;
        intArray[2] = 3;
        intArray[3] = 4;
        intArray[4] = 5;

        List<String> stringArrayList = new ArrayList<>();
        stringArrayList.stream()
                .filter(x -> x.equals("1"))
                .map(x -> x.equals("1"))
                .collect(Collectors.toList());
        stringArrayList.stream().forEach(System.out::println);
    }
}
