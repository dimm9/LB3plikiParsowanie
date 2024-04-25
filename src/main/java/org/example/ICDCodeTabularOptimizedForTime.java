package org.example;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class ICDCodeTabularOptimizedForTime implements ICDCodeTabular{
    Map<String, String> icd10Map = new HashMap<>();
    public ICDCodeTabularOptimizedForTime(String path) {
        try(BufferedReader reader = new BufferedReader(new FileReader(path))) {
            reader.skip(87);
            String line;
            while((line = reader.readLine())!=null){
                String[] code = line.split(" ", 2);
                if(code.length > 1) {
                    icd10Map.put(code[0], code[1].replace("\t", ""));
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String getDescription(String icd10) {
        if(icd10 == null){
            throw new IndexOutOfBoundsException();
        }
        return icd10Map.get(icd10);
    }
}
