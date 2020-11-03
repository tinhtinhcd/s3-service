package group3.s3;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

@EnableEurekaClient
@SpringBootApplication
public class S3ServiceApplication {
	public static void main(String[] args) {
		SpringApplication.run(S3ServiceApplication.class, args);
	}

}
