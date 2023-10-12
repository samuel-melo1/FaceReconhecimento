package com.project.facereconhecimento.controller;

import com.project.facereconhecimento.model.Pessoa;
import org.apache.tomcat.util.json.JSONParser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import com.project.facereconhecimento.payload.UploadFileResponse;
import com.project.facereconhecimento.service.FileStorageService;

import java.beans.BeanProperty;
import java.util.List;


@RestController
@RequestMapping("/api/files")
public class FileController {

    private static final Logger logger = LoggerFactory.getLogger(FileController.class);

    @Autowired
    private FileStorageService fileStorageService;
    
    @PostMapping("/uploadFile")
    public ResponseEntity<Object> uploadFile(@RequestParam("file") MultipartFile file) {
        String fileName = fileStorageService.storeFile(file);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
    

