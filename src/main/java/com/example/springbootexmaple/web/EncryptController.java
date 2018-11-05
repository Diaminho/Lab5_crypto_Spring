package com.example.springbootexmaple.web;

import com.example.springbootexmaple.service.EncryptService;
import com.example.springbootexmaple.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class EncryptController {
    EncryptService encryptService;
    FileService fileService;
    private ModelMap modelMap;

    @Autowired
    public EncryptController() {
        this.encryptService = new EncryptService();
        this.fileService=new FileService();
        this.modelMap = new ModelMap();
    }

    @PostMapping(value = "/encrypt")
    public ModelAndView result(ModelMap modelMap, @RequestParam(value="fileName") String fileName,@RequestParam(value="keyFile") String keyFile) {
        String info=fileService.getInfoFromFile(fileName);
        String key=fileService.getInfoFromFile(keyFile);
        modelMap.put("encryptedText",encryptService.doAllWorkForEncrypt(info,key));
        modelMap.put("originalText",info);
        modelMap.put("originalKey",key);

        return new ModelAndView("encrypt");
    }

}