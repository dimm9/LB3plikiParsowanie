package org.example;

import java.util.List;

public class Main {
    public static void main(String[] args) {
            DeathCauseStatisticList stats = new DeathCauseStatisticList();
            stats.repopulate("zgony.csv");
            List<DeathCauseStatistic> sorted = stats.mostDeadlyDiseases(4, 5);
            sorted.forEach(System.out::println);
            ICDCodeTabularOptimizedForTime code = new ICDCodeTabularOptimizedForTime("icd10.txt");
            System.out.println(code.getDescription("A75-A79"));
            ICDCodeTabularOptimizedForMemory memory = new ICDCodeTabularOptimizedForMemory("icd10.txt");
            System.out.println(memory.getDescription("A90-A99"));
        }
    }
