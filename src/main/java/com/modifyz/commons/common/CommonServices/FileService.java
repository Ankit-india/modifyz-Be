package com.modifyz.commons.common.CommonServices;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import org.springframework.web.multipart.MultipartFile;

public interface FileService {

    String uploadImages(MultipartFile[] imagesList) throws IOException;

    InputStream getResources(String path, String image) throws FileNotFoundException;
}
