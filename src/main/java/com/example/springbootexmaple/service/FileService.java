package com.example.springbootexmaple.service;


import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

@Service
public class FileService {

    public FileService(){ }

    public String getInfoFromFile(String path) {
        String tmpStr;
        String infoString = "";
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            while ((tmpStr = br.readLine()) != null) {
                infoString += tmpStr + '\n';
            }
            return infoString;
        } catch (IOException e) {
            System.out.println(e);
            return "-1";
        }
    }
}
