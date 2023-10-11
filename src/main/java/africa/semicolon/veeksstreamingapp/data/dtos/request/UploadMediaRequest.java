package africa.semicolon.veeksstreamingapp.data.dtos.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UploadMediaRequest {
    private MultipartFile multipartFile;
    private Long creatorId;
    private String description;
    private String title;
}
