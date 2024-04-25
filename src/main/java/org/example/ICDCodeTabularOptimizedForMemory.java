package org.example;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ICDCodeTabularOptimizedForMemory implements ICDCodeTabular{

    private String path;

    public ICDCodeTabularOptimizedForMemory(String path) {
        this.path = path;
    }

    @Override
    public String getDescription(String icd10) {
        try(BufferedReader reader = new BufferedReader(new FileReader(path))){
            reader.skip(87);
            String line;
            while((line = reader.readLine())!=null){
                String[] code = line.split(" ", 2);
                if(code.length > 1 && code[0].equals(icd10)) {
                    return code[1].replace("\t", " ");
                }else if(code.length == 1 && code[0].equals(icd10)){
                    throw new IndexOutOfBoundsException();
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return null;
    }
    //Klasa ICDCodeTabularOptimizedForMemory nie powinna przetrzymywać d
    // anych w pamięci operacyjnej, ale za każdym wywołaniem metody
    // getDescription powinna otwierać plik i wyszukiwać w nim opisu.
}
