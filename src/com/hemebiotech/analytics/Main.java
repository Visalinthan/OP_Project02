package com.hemebiotech.analytics;

import java.util.Map;

public class Main {
    public static void main(String args[]) throws Exception {
        ReadSymptomDataFromFile file = new ReadSymptomDataFromFile("symptoms.txt");
        Map<String,Integer> myMap = file.countSymptoms(file.getSymptoms());
        file.writerSymptoms(myMap);

    }
}