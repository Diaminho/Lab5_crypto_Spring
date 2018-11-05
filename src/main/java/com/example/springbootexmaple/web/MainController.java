package com.example.springbootexmaple.web;

import com.example.springbootexmaple.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.swing.*;

@Controller
public class MainController {
    private FileService fileService;
    private ModelMap modelMap;

    public FileService getFileService() {
        return fileService;
    }

    @Autowired
    public MainController() {
        this.fileService=new FileService();
        //this.modelMap = new ModelMap();
    }

    @GetMapping("main")
    public ModelAndView encrypting(ModelMap modelMap) {
        //this.modelMap=modelMap;
        //modelMap.put("fileBrowser", fileService.getFileBrowser());
        return new ModelAndView("main",modelMap);
    }

    @PostMapping("fileBrowser")
    public ModelAndView fileBrowser(ModelMap modelMap) {
        modelMap.put("fileName",fileService.getFileFromFileChooser());
        //this.modelMap=modelMap;
        ModelAndView mav=new ModelAndView("main",modelMap);
        return mav;
    }

    @PostMapping("getKeyFile")
    public ModelAndView getKeyFile(ModelMap modelMap) {
        modelMap.put("keyFile",fileService.getFileFromFileChooser());
        //this.modelMap=modelMap;
        ModelAndView mav=new ModelAndView("main",modelMap);
        return mav;
    }

}
