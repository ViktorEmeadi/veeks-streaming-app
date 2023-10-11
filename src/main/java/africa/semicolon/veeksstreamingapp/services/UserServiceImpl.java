package africa.semicolon.veeksstreamingapp.services;

import africa.semicolon.veeksstreamingapp.data.dtos.request.EmailRequest;
import africa.semicolon.veeksstreamingapp.data.dtos.request.Receiver;
import africa.semicolon.veeksstreamingapp.data.dtos.request.RegisterRequest;
import africa.semicolon.veeksstreamingapp.data.dtos.request.Sender;
import africa.semicolon.veeksstreamingapp.data.dtos.response.RegisterResponse;
import africa.semicolon.veeksstreamingapp.data.models.User;
import africa.semicolon.veeksstreamingapp.data.repositories.UserRepository;
import africa.semicolon.veeksstreamingapp.exceptions.GemsTubeException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService{
    private final UserRepository repository;
    private final MailService mailService;

    public UserServiceImpl(UserRepository repository, MailService mailService) {
        this.repository = repository;
        this.mailService = mailService;
    }

    @Override
    public RegisterResponse register(RegisterRequest request) {
        User user = User.builder()
                .email(request.getEmail())
                .passwords(request.getPassword())
                .build();
        User registeredUser = repository.save(user);
        Sender sender = new Sender();
        sender.setName("vee");
        sender.setEmail("veetoreme@gmail.com");
        EmailRequest emailRequest = new EmailRequest();
        emailRequest.setSender(sender);
        emailRequest.setReceiver(List.of(new Receiver(registeredUser.getEmail(), "")));
        emailRequest.setContent("<p>Just a good ol' ride</p>");
        emailRequest.setSubject("<h1>And a Happy New Year</h1>");
        mailService.sendMail(emailRequest);
        return new RegisterResponse(registeredUser.getId());
    }

    @Override
    public User getUserById(Long creatorId) throws GemsTubeException {
        return repository.findById(creatorId)
                .orElseThrow(() -> new GemsTubeException(String.format("User not found " + creatorId)));
    }
}
