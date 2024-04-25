package org.example;

import java.util.Arrays;

public class DeathCauseStatistic {

    private String icd10;
    private int[] deaths;

    public DeathCauseStatistic(String icd10, int[] deaths) {
        this.icd10 = icd10;
        this.deaths = deaths;
    }

    public String getIcd10() {
        return icd10;
    }
    public static DeathCauseStatistic fromCsvLine(String line) {
        String[] parts = line.split(",");
        String icd10 = parts[0].replace("\t", "");
        int[] deaths = new int[parts.length - 1];
        for (int i = 0; i < parts.length-1; i++) {
            deaths[i] = parts[i+1].contains("-") ? 0 : Integer.parseInt(parts[i+1]);
        }
        return new DeathCauseStatistic(icd10, deaths);
    }
    public AgeBracketDeaths ageGapDeaths(int age){
        int index = age > 95 ? deaths.length-1 : age/5;
        int deathCount = deaths[index];
        int young = index*5;
        int old = young+4;
        return new AgeBracketDeaths(young, old, deathCount);
    }

    @Override
    public String toString() {
        return "DeathCauseStatistic{" +
                "icd10='" + icd10 + '\'' +
                ", deaths=" + Arrays.toString(deaths) +
                '}';
    }

    public record AgeBracketDeaths(int young, int old, int deathCount){}
}
//W klasie DeathCauseStatistic napisz metodę przyjmującą wiek i
// zwracającą obiekt AgeBracketDeaths odpowiadający temu wiekowi.