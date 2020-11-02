package group3.s3.controller;

import group3.s3.entity.ResponseError;
import group3.s3.entity.ResponseUrl;
import group3.s3.service.S3Service;
import group3.s3.utils.FileValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/api")
public class UploadController {

    private S3Service s3Service;
    FileValidator fileValidator;

    @Autowired
    public void setFileValidator(FileValidator fileValidator) {
        this.fileValidator = fileValidator;
    }

    @Autowired
    public void setS3Service(S3Service s3Service) {
        this.s3Service = s3Service;
    }

    @PostMapping(value = "/uploadImage")
    public ResponseEntity<Object> createPost(@RequestParam(required = false) @Valid MultipartFile file) {
        //        String medias = s3Service.uploadFile(file);
        //        return new ResponseEntity<>(medias, HttpStatus.OK);
        String error = fileValidator.validate(file);
        if (error.length() > 0) {
            return new ResponseEntity<>(ResponseError.builder().error(error).build(), HttpStatus.UNSUPPORTED_MEDIA_TYPE);
        }
        String dummy = "https://elasticbeanstalk-us-west-1-425277212426.s3.amazonaws.com/group3-image/file260275551504320";
        return new ResponseEntity<>(ResponseUrl.builder().url(dummy).build(), HttpStatus.OK);
    }

}
