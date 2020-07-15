package springboot.amazonreviews;

import java.nio.file.Path;
import java.util.List;
import java.util.Objects;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springboot.amazonreviews.util.ReadFileWithReviews;

@SpringBootApplication
public class AmazonReviewsApplication {
    public static void main(String[] args) {
        Path downloadFilePath = ReadFileWithReviews
                .downloadFile(
                        "https://spring-boot-aws-revievers.s3.eu-central-1.amazonaws.com/Reviews.csv",
                        "D:\\Project\\amazon-reviews\\src\\main\\resources\\");
        List<String> list = ReadFileWithReviews
                .readFromFile(Objects.requireNonNull(downloadFilePath).toString());
        for (String str : Objects.requireNonNull(list)) {
            System.out.println(str);
        }
        SpringApplication.run(AmazonReviewsApplication.class, args);
    }
}
