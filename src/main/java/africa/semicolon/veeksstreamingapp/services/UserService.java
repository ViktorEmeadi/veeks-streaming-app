package africa.semicolon.veeksstreamingapp.services;

import africa.semicolon.veeksstreamingapp.data.dtos.request.RegisterRequest;
import africa.semicolon.veeksstreamingapp.data.dtos.response.RegisterResponse;
import org.springframework.stereotype.Service;

public interface UserService {
    RegisterResponse register(RegisterRequest request);
}
