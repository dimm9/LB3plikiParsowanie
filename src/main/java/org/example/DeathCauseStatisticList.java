package org.example;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class DeathCauseStatisticList {
    List<DeathCauseStatistic> statistic = new ArrayList<>();
    public void repopulate(String path){
        statistic.clear();
        try(BufferedReader reader = new BufferedReader(new FileReader(path))) {
            reader.readLine();
            String line;
            while((line = reader.readLine()) != null){
                statistic.add(DeathCauseStatistic.fromCsvLine(line));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public List<DeathCauseStatistic> mostDeadlyDiseases(int age, int n){
        return statistic.stream()
                .sorted(Comparator.comparingInt((DeathCauseStatistic s) -> s.ageGapDeaths(age).deathCount()).reversed())
                .limit(n).collect(Collectors.toList());
    }
}
