package africa.semicolon.veeksstreamingapp.services;

import africa.semicolon.veeksstreamingapp.config.CloudConfig;
import africa.semicolon.veeksstreamingapp.exceptions.MediaUploadException;
import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Map;

@Service
public class CloudinaryCloudService implements CloudService{
    private final CloudConfig config;

    public CloudinaryCloudService(CloudConfig config) {
        this.config = config;
    }
    @Override
    public String upload(MultipartFile file) throws MediaUploadException {

        Cloudinary cloudinary = new Cloudinary(ObjectUtils.asMap(
                "cloud_name",config.getCloudName(),
                "api_key",config.getApikey(),
                "api_secret",config.getApiSecret(),
                "secure", "true"));
        try{
        Map<?, ?> uploadResponse = cloudinary.uploader().upload(file, ObjectUtils.emptyMap());
        String url = (String) uploadResponse.get("secure-url");
        return url;
        } catch (IOException ex){
            throw new MediaUploadException(ex.getMessage());
        }
    }
}
