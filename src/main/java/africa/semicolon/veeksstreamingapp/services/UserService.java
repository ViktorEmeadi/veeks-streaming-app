package africa.semicolon.veeksstreamingapp.services;

import africa.semicolon.veeksstreamingapp.data.dtos.request.RegisterRequest;
import africa.semicolon.veeksstreamingapp.data.dtos.response.RegisterResponse;
import africa.semicolon.veeksstreamingapp.data.models.User;
import africa.semicolon.veeksstreamingapp.exceptions.GemsTubeException;
import org.springframework.stereotype.Service;

public interface UserService {
    RegisterResponse register(RegisterRequest request);

    User getUserById(Long creatorId) throws GemsTubeException;
}
