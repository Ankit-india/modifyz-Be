package com.modifyz.commons.common.CommonServices.controller;

import com.modifyz.commons.common.CommonServices.FileService;
import com.modifyz.controller.ShopController;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@Slf4j
@RestController
@RequestMapping("/api/v1/file")
public class FileController {

    private Logger logger = LoggerFactory.getLogger(ShopController.class);

    @Autowired
    private FileService fileService;

    @PostMapping(value = "/uploadImages")
    public ResponseEntity<?> uplaod(@RequestParam("images") MultipartFile[] imagesList) throws
        IOException {
        fileService.uploadImages(imagesList);
        logger.info("{} files uploaded", imagesList.length);
        return new ResponseEntity<>("fileUploaded Successfully", HttpStatus.OK);
    }


    @GetMapping(value = "/{folderName}/{imageName}")
    public void getImages(
        @PathVariable("folderName") String folderName,
        @PathVariable("imageName") String imageName,
        HttpServletResponse response) throws IOException {
        InputStream resource = fileService.getResources(folderName, imageName);
        response.setContentType("");
        StreamUtils.copy(resource, response.getOutputStream());
    }

}
