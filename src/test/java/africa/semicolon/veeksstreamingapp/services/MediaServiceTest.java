package africa.semicolon.veeksstreamingapp.services;

import africa.semicolon.veeksstreamingapp.data.dtos.request.UploadMediaRequest;
import africa.semicolon.veeksstreamingapp.data.dtos.response.UploadMediaResponse;
import com.cloudinary.api.ApiResponse;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.ClassBasedNavigableIterableAssert.assertThat;


@SpringBootTest
public class MediaServiceTest {
    @Autowired
    private MediaService mediaService;

    @Test
    public void testUploadMediaFile(){
        UploadMediaRequest request = new UploadMediaRequest();
//        UploadMediaResponse response = mediaService.upload(request);
//        assertThat(response).isNotNull();
    }
}
