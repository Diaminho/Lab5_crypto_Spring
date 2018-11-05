package com.example.springbootexmaple.web;

import com.example.springbootexmaple.service.DecryptService;
import com.example.springbootexmaple.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class DecryptController {
    DecryptService decryptService;
    FileService fileService;
    private ModelMap modelMap;

    @Autowired
    public DecryptController() {
        this.decryptService = new DecryptService();
        this.fileService=new FileService();
        this.modelMap = new ModelMap();
    }

    @PostMapping(value = "/decrypt")
    public ModelAndView result(ModelMap modelMap, @RequestParam(value="fileName") String fileName, @RequestParam(value="keyFile") String keyFile) {
        String info=fileService.getInfoFromFile(fileName);
        String key=fileService.getInfoFromFile(keyFile);
        modelMap.put("decryptedText",decryptService.doDecrypt(info,key));
        modelMap.put("originalEncText",info);
        modelMap.put("originalKey",key);

        return new ModelAndView("decrypt");
    }
}
