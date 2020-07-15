package springboot.amazonreviews.util;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import org.junit.Assert;
import org.junit.Test;

public class ReadFileWithReviewsTest {

    @Test
    public void readFromFileTest() {
        String testFileName = "testFile.txt";
        String expected = "my test";
        List<String> stringsExpected = new ArrayList<>();
        stringsExpected.add(expected);
        List<String> stringsResult = ReadFileWithReviews.readFromFile(testFileName);
        Assert.assertEquals(stringsExpected, stringsResult);
    }

    @Test
    public void downloadFileTest() {
        String sourceFilePath =
                "https://spring-boot-aws-revievers.s3.eu-central-1.amazonaws.com/Reviews.csv";
        String downloadFileDirectory = "D:\\Project\\amazon-reviews\\src\\main\\resources\\";
        String expected = "D:\\Project\\amazon-reviews\\src\\main\\resources\\Reviews.csv";
        Path downloadFilePath = ReadFileWithReviews
                .downloadFile(sourceFilePath, downloadFileDirectory);
        Assert.assertEquals(expected, Objects.requireNonNull(downloadFilePath).toString());
    }
}
