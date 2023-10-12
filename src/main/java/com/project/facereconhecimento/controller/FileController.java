package com.project.facereconhecimento.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import com.project.facereconhecimento.service.FileStorageService;



@RestController
@RequestMapping("/api/files")
public class FileController {

    private static final Logger logger = LoggerFactory.getLogger(FileController.class);

    @Autowired
    private FileStorageService fileStorageService;
    
    @PostMapping("/uploadFile/{cpf}")
    public ResponseEntity<Object> uploadFile(@RequestParam("file") MultipartFile file, @PathVariable String cpf) {
        String fileName = fileStorageService.storeFile(file, cpf);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
    

