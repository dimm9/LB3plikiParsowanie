package org.example;

@FunctionalInterface
public interface ICDCodeTabular {
    public String getDescription(String icd10);
}
//Napisz interfejs ICDCodeTabular posiadający jedną, publiczną metodę
// getDescription, która dla podanego kodu choroby zwróci jej opis,
// lub gdy takiego kodu nie odnajdzie rzuci wyjątek IndexOutOfBoundsException.

// Zaimplementuj ten interfejs w dwóch klasach ICDCodeTabularOptimizedForTime
// oraz ICDCodeTabularOptimizedForMemory.