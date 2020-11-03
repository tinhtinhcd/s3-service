package group3.s3.utils;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.util.Arrays;
import java.util.List;

@Component
public class FileValidator{

    List<String> types = Arrays.asList("image", "pdf", "jrxml");
    String error;

    public String validate(MultipartFile target) {

        if (target== null || target.getSize() == 0) {
            return  "missing file";
        }

        String mimeType = target.getContentType();
        String type[] = mimeType.split("/");

        if (!types.contains(type[0]) && !types.contains(type[1])){
            error = ("fileType mismatch " + target.getName());
        }

        return error;
    }
}
