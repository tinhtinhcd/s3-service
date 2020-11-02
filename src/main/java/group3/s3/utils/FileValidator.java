package group3.s3.utils;

import org.apache.tomcat.util.http.fileupload.FileUpload;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import java.util.Arrays;
import java.util.List;

@Component
public class FileValidator{

    List<String> types = Arrays.asList("image", "pdf", "jrxml");
    String error;

    public String validate(MultipartFile target) {

        if (target.getSize() == 0) {
            error = ("files missing.file " + target.getName());
        }

        String mimeType = target.getContentType();
        String type = mimeType.split("/")[0];

        if (!types.contains(type)){
            error = ("fileType mismatch " + target.getName());
        }

        return error;
    }
}
