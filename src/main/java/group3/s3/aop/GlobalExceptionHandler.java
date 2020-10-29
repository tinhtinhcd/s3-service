package group3.s3.aop;

import group3.s3.entity.ResponseError;
import org.apache.tomcat.util.http.fileupload.impl.FileSizeLimitExceededException;
import org.apache.tomcat.util.http.fileupload.impl.SizeLimitExceededException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.multipart.MaxUploadSizeExceededException;
import org.springframework.web.multipart.MultipartException;

@ControllerAdvice
public class GlobalExceptionHandler {

    @Autowired
    private MessageSource messageSource;


    @ExceptionHandler(MultipartException.class)
    public ResponseEntity<ResponseError> handleMultipartException(Exception ex) {
        Throwable se = ex.getCause().getCause();
        if(ex instanceof MaxUploadSizeExceededException){
            String message = messageSource.getMessage(
                    "file.maxsize",
                    new Object[]{((FileSizeLimitExceededException)se).getFieldName(),
                            ((MaxUploadSizeExceededException) ex).getMaxUploadSize()},
                    LocaleContextHolder.getLocale());
            return new ResponseEntity<>(ResponseError.builder().message(message).build(), HttpStatus.PAYLOAD_TOO_LARGE);
        }
        else if (se instanceof SizeLimitExceededException){
            return new ResponseEntity<>(ResponseError.builder().message(se.getMessage()).build(), HttpStatus.PAYLOAD_TOO_LARGE);
        }
        return new ResponseEntity<>(ResponseError.builder().message(ex.getMessage()).build(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
