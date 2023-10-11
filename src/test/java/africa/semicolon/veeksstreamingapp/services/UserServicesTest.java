package africa.semicolon.veeksstreamingapp.services;

import africa.semicolon.veeksstreamingapp.data.dtos.request.RegisterRequest;
import africa.semicolon.veeksstreamingapp.data.dtos.response.RegisterResponse;
import africa.semicolon.veeksstreamingapp.data.models.User;
import africa.semicolon.veeksstreamingapp.exceptions.GemsTubeException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.ClassBasedNavigableIterableAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class UserServicesTest {
    @Autowired
    UserService userService;

    private RegisterRequest registerRequest;
    private RegisterResponse response;
    @BeforeEach
    public void setUp(){
        registerRequest = new RegisterRequest();
        registerRequest.setEmail("me@gmail.com");
        registerRequest.setPassword("123456");
        response = userService.register(registerRequest);
    }
    @Test
    public void registerTest(){

        assertNotNull(response);
        assertNotNull(response.getId());
    }


    @Test
    public void testGetUserById() throws GemsTubeException {RegisterRequest request = new RegisterRequest();
        User user = userService.getUserById(1L);
        assertNotNull(user);
    }
}
