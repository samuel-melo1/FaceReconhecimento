package com.project.facereconhecimento.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.Stream;
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
        int counter = getNumberOfImagesForPerson(cpf);
        String fileName = fileStorageService.storeFile(file, cpf, counter);

        return ResponseEntity.status(HttpStatus.OK).body(fileName);
    }

    private int getNumberOfImagesForPerson(String cpf) {
        try {
            Path fileStorageLocation = fileStorageService.getFileStorageLocation(); // Obtenha o local do armazenamento
                                                                                    // de arquivos do serviço
            Stream<Path> list = Files.list(fileStorageLocation);
            long count = list
                    .filter(path -> path.getFileName().toString().startsWith(cpf + "_"))
                    .count();

            return (int) count;
        } catch (IOException e) {
            e.printStackTrace();
            return -1;
        }
    }
}
