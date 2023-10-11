package africa.semicolon.veeksstreamingapp.services;

import africa.semicolon.veeksstreamingapp.exceptions.MediaUploadException;
import org.springframework.web.multipart.MultipartFile;

public interface CloudService {
    String upload(MultipartFile file) throws MediaUploadException;
}
