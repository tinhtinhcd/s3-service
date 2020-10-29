package group3.s3.controller;

import group3.s3.service.S3Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/api")
public class UploadController {

    private S3Service s3Service;

    @Autowired
    public void setS3Service(S3Service s3Service) {
        this.s3Service = s3Service;
    }

    @PostMapping(value = "/uploadImage")
    public ResponseEntity<String> createPost(@RequestParam(required = false) @Valid MultipartFile file) {
//        String medias = s3Service.uploadFile(file);
//        return new ResponseEntity<>(medias, HttpStatus.OK);
        String dummy = "https://elasticbeanstalk-us-west-1-425277212426.s3.amazonaws.com/group3-image/file260275551504320";
        return new ResponseEntity<>(dummy,HttpStatus.OK);
    }

}
