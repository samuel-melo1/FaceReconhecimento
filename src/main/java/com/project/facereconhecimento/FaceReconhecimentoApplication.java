package com.project.facereconhecimento;

import com.project.facereconhecimento.properties.FileStorageProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties({
        FileStorageProperties.class
})
public class FaceReconhecimentoApplication {

    public static void main(String[] args) {
        SpringApplication.run(FaceReconhecimentoApplication.class, args);
    }

}
