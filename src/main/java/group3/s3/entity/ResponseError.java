package group3.s3.entity;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ResponseError {
    String message;
}
