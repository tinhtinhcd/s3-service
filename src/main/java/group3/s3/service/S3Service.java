package group3.s3.service;

import org.springframework.web.multipart.MultipartFile;

public interface S3Service {
    String uploadFile(MultipartFile file);
}
