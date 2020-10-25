package group3.s3.config;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Data
@Component
public class S3Config {

    @Value("${s3.environment.AWS_ACCESS_KEY}")
    private String awsKeyId;

    @Value("${s3.environment.AWS_SECRET_KEY}")
    private String awsSecretKey;

    @Value("${s3.environment.AWS_REGION}")
    private String region;

    @Value("${s3.environment.BUCKET}")
    private String bucket;

    @Value("${s3.environment.IMAGE_FOLDER}")
    private String imageFolder;

    @Bean
    public AmazonS3 s3client() {
        BasicAWSCredentials awsCreds = new BasicAWSCredentials(awsKeyId, awsSecretKey);
        return AmazonS3ClientBuilder.standard()
                .withRegion(Regions.fromName(region))
                .withCredentials(new AWSStaticCredentialsProvider(awsCreds))
                .build();
    }
}
