package africa.semicolon.veeksstreamingapp.services;

import africa.semicolon.veeksstreamingapp.data.dtos.request.RegisterRequest;
import africa.semicolon.veeksstreamingapp.data.dtos.response.RegisterResponse;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class UserServicesTest {
    @Autowired
    UserService userService;
    @Test
    public void registerTest(){
        RegisterRequest request = new RegisterRequest();
        request.setEmail("me@gmail.com");
        request.setPassword("123456");

        RegisterResponse response = userService.register(request);
        assertNotNull(response);
        assertNotNull(response.getId());
    }
}
