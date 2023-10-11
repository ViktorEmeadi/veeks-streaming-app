package africa.semicolon.veeksstreamingapp.services;

import africa.semicolon.veeksstreamingapp.data.dtos.request.EmailRequest;
import africa.semicolon.veeksstreamingapp.data.dtos.request.Receiver;
import africa.semicolon.veeksstreamingapp.data.dtos.request.Sender;
import africa.semicolon.veeksstreamingapp.data.dtos.response.EmailResponse;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class MailServiceTest {
    @Autowired
    private MailService mailService;
    @Test
    public void testSendMail(){
        EmailRequest emailRequest = new EmailRequest();
        Sender sender = new Sender();
        sender.setEmail("veetoreme@gmail.com");
        sender.setName("vee");

        Receiver receiver = new Receiver();
        receiver.setName("Sammy");
        receiver.setEmail("samueltamunotope@gmail.com");
        List<Receiver> receiverList = new ArrayList<>();
        receiverList.add(receiver);
        emailRequest.setReceiver(receiverList);
        emailRequest.setSender(sender);
        emailRequest.setSubject("<h1>A Greeting</h1>");
        emailRequest.setContent("<p>Greetings most noble man of Niagara falls</p>");

        EmailResponse response = mailService.sendMail(emailRequest);
        assertNotNull(response);
        assertNotNull(response.getMessageId());
    }
}
