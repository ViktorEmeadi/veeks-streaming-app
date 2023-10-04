package africa.semicolon.veeksstreamingapp.services;

import africa.semicolon.veeksstreamingapp.data.dtos.request.RegisterRequest;
import africa.semicolon.veeksstreamingapp.data.dtos.response.RegisterResponse;
import africa.semicolon.veeksstreamingapp.data.models.User;
import africa.semicolon.veeksstreamingapp.data.repositories.UserRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{
    private final UserRepository repository;

    public UserServiceImpl(UserRepository repository) {
        this.repository = repository;
    }

    @Override
    public RegisterResponse register(RegisterRequest request) {
        User user = User.builder()
                .email(request.getEmail())
                .passwords(request.getPassword())
                .build();
        RegisterResponse response = new RegisterResponse();
        User registeredUser = repository.save(user);
        BeanUtils.copyProperties(registeredUser, response);
        return response;
    }
}
