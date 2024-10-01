package com.ex.controller;

import com.ex.service.FileService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;

@RequestMapping("import")
@RestController
public class ImportExcelController {
    @Resource
    private FileService fileService;

    @RequestMapping("/file")
    public int importFile(MultipartFile file){

        return 0;

    }
}
