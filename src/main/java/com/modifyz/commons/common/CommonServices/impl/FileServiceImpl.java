package com.modifyz.commons.common.CommonServices.impl;

import com.modifyz.commons.common.CommonServices.FileService;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class FileServiceImpl implements FileService {

    @Value("${project.images}")
    private String path;

    @Override public String uploadImages(MultipartFile[] imagesList)
        throws IOException {
        System.out.println(imagesList.length);
        for(MultipartFile image: imagesList) {
            String imgName = image.getOriginalFilename();

            String randomId = UUID.randomUUID().toString();

            String newImageName = randomId.concat(imgName.substring(imgName.lastIndexOf(".")));

            String filePath = path + File.separator + newImageName;

            File f = new File(path);

            if(!f.exists()) {
                f.mkdir();
            }

            Files.copy(image.getInputStream(), Paths.get(filePath));
        }
        return "completed";

    }

    @Override public InputStream getResources(String path, MultipartFile[] imagesList) {
        return null;
    }
}
