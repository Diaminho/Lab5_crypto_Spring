package com.example.springbootexmaple.web;

import com.example.springbootexmaple.service.EncryptService;
import com.example.springbootexmaple.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class EncryptingController {
    EncryptService encryptService;
    FileService fileService;
    private ModelMap modelMap;

    @Autowired
    public EncryptingController() {
        this.encryptService = new EncryptService();
        this.fileService=new FileService();
        this.modelMap = new ModelMap();
    }

    @RequestMapping(value = "/encrypting", method = RequestMethod.GET)
    public ModelAndView encrypting(ModelMap modelMap) {
        this.modelMap=modelMap;
        this.modelMap.addAttribute("encrypting", encryptService);
        return new ModelAndView("encrypting");
    }


    @PostMapping(value = "/result")
    public ModelAndView result(ModelMap modelMap, @RequestParam(value="fileName") String fileName,@RequestParam(value="keyFile") String keyFile) {
        String info=fileService.getInfoFromFile(fileName);
        String key=fileService.getInfoFromFile(keyFile);
        modelMap.put("encryptedText",encryptService.doAllWorkForEncrypt(info,key));
        modelMap.put("originalText",info);
        modelMap.put("originalKey",key);

        return new ModelAndView("result");
    }

}