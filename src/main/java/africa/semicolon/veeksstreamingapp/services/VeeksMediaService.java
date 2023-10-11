package africa.semicolon.veeksstreamingapp.services;

import africa.semicolon.veeksstreamingapp.data.dtos.request.UploadMediaRequest;
import africa.semicolon.veeksstreamingapp.data.dtos.response.UploadMediaResponse;
import africa.semicolon.veeksstreamingapp.data.models.Media;
import africa.semicolon.veeksstreamingapp.data.models.User;
import africa.semicolon.veeksstreamingapp.exceptions.GemsTubeException;
import africa.semicolon.veeksstreamingapp.exceptions.MediaUploadException;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class VeeksMediaService implements MediaService{
    private final CloudService cloudService;
    private final UserService userService;

    public VeeksMediaService(CloudService cloudService, UserService userService) {
        this.cloudService = cloudService;
        this.userService = userService;
    }


    @Override
    public UploadMediaResponse upload(UploadMediaRequest request) throws GemsTubeException {
        User user = userService.getUserById(request.getCreatorId());
        String url = cloudService.upload(request.getMultipartFile());
        Media media = Media.builder()
                .url(url)
                .title(request.getTitle())
                .description(request.getDescription())
                .dateUploaded(LocalDate.now())
                .uploader(user)
                .build();
        return null;
    }
}
