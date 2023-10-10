package com.FileUploadMultipart.service;

import com.FileUploadMultipart.entity.ImageData;
import com.FileUploadMultipart.repository.StorageRepository;
import com.FileUploadMultipart.util.ImageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Optional;

@Service
public class StorageService {

    @Autowired
    private StorageRepository storageRepository;

    public String uploadImage(MultipartFile multipartFile) throws IOException {
            ImageData imageData = storageRepository.save(ImageData.builder()
                    .name(multipartFile.getOriginalFilename())
                    .type(multipartFile.getContentType())
                    .imageData(ImageUtil.compressImage(multipartFile.getBytes()))
                    .build());
            if (imageData != null) {
                return "File Uploaded Successfully: " + multipartFile.getOriginalFilename();
            } else {
                return "File Upload Failed";
            }
    }

    public byte[] downloadImage(String fileName) {
            Optional<ImageData> dbImageData = storageRepository.findByName(fileName);

            if (dbImageData.isPresent()) {
                return ImageUtil.decompressImage(dbImageData.get().getImageData());
            } else {
                System.out.println("Image not found: " + fileName);
                return null;
            }
    }
}
