package group3.s3.utils;

import org.apache.tomcat.util.http.fileupload.FileUpload;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import java.util.Arrays;
import java.util.List;

@Component
public class FileValidator{

    List<String> types = Arrays.asList("image", "pdf", "jrxml");
    String error;

    public String validate(Object target) {
        CommonsMultipartFile[] fileUpload = (CommonsMultipartFile[]) target;

        for (CommonsMultipartFile multipartFile : fileUpload) {
            if (multipartFile.getSize() == 0) {
                error = ("files missing.file " + multipartFile.getName());
            }

            String mimeType = multipartFile.getContentType();
            String type = mimeType.split("/")[0];

            if (!types.contains(type)){
                error = ("fileType mismatch " + multipartFile.getName());
            }
        }

        return error;
    }
}
