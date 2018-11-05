package com.example.springbootexmaple.service;


import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.File;
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

    public String getFileFromFileChooser(){
        JFileChooser fileopen = new JFileChooser();
        int ret = fileopen.showDialog(null, "Открыть файл");
        if (ret == JFileChooser.APPROVE_OPTION) {
            File file = fileopen.getSelectedFile();
            String fileName=file.getAbsolutePath();
            System.out.println("Имя файла: "+fileName);
            //file.;
            return fileName;
        }
        else return "None";
    }

}
