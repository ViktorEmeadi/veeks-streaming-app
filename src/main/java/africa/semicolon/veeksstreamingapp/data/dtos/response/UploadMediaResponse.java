package africa.semicolon.veeksstreamingapp.data.dtos.response;

import org.springframework.web.multipart.MultipartFile;

public class UploadMediaResponse {
    private MultipartFile multipartFile;
    private Long creatorId;
    private String description;
    private String title;
}
