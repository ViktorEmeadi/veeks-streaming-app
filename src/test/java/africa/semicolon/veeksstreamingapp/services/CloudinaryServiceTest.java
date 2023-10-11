package africa.semicolon.veeksstreamingapp.services;

import africa.semicolon.veeksstreamingapp.exceptions.MediaUploadException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class CloudinaryServiceTest {
    @Autowired
    private CloudService cloudService;
    @Test
    public void testUploadFile(){
        Path path = Paths.get("C:\\Users\\GIDEON\\Desktop\\veeks-streaming-app\\veeks-stre" +
                "aming-app\\src\\main\\resources\\assets\\AvatarModel_Thumbnail.jpg");
        try(var inputStream = Files.newInputStream(path)){
            MultipartFile file = new MockMultipartFile("test-image", inputStream);
            String response = cloudService.upload(file);
            assertNotNull(response);
        }catch (IOException | MediaUploadException ex){
            System.err.println(ex.getMessage());
        }
    }
}
