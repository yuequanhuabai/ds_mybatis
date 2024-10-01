package com.ex.service.impl;

import com.ex.service.FileService;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class FileServiceImpl implements FileService {


    @Override
    public int parseExcel(MultipartFile file) {
//        Files.write()
        return 0;
    }


}
