package group3.s3.utils;

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
            error = ("files missing.file ");
        }

        String mimeType = target.getContentType();
        String type = mimeType.split("/")[0];

        if (!types.contains(type)){
            error = ("fileType mismatch " + target.getName());
        }

        return error;
    }
}
