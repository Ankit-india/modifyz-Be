package com.modifyz.commons.common.CommonServices.controller;

import com.modifyz.commons.common.CommonServices.FileService;
import java.io.IOException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@Slf4j
@RestController
@RequestMapping("/api/v1/file")
public class FileController {

    @Autowired
    private FileService fileService;

    @PostMapping("/upload")
    public ResponseEntity<?> fileUpload(@RequestParam("images")MultipartFile[] imagesList)
        throws IOException {
        fileService.uploadImages(imagesList);
        return new ResponseEntity<>("Successfully Uploaded", HttpStatus.OK);
    }
}
