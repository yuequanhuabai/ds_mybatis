package com.ex.service;

import org.springframework.web.multipart.MultipartFile;

public interface FileService {
    int parseExcel(MultipartFile file);
}
