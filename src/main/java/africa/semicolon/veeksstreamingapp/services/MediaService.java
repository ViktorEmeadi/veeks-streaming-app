package africa.semicolon.veeksstreamingapp.services;

import africa.semicolon.veeksstreamingapp.data.dtos.request.UploadMediaRequest;
import africa.semicolon.veeksstreamingapp.data.dtos.response.UploadMediaResponse;
import africa.semicolon.veeksstreamingapp.exceptions.GemsTubeException;
import africa.semicolon.veeksstreamingapp.exceptions.MediaUploadException;

public interface MediaService {
    UploadMediaResponse upload(UploadMediaRequest request) throws GemsTubeException;
}
