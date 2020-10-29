package group3.s3.entity;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class MediaDto {

    private String mediaType;
    @NotNull
    private String url;
}