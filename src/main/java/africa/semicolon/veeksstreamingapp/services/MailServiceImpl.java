package africa.semicolon.veeksstreamingapp.services;

import africa.semicolon.veeksstreamingapp.config.MailConfig;
import africa.semicolon.veeksstreamingapp.data.dtos.request.EmailRequest;
import africa.semicolon.veeksstreamingapp.data.dtos.response.EmailResponse;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


import java.net.URI;

import static org.springframework.http.HttpMethod.POST;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@Service
public class MailServiceImpl implements MailService{

    private final MailConfig mailConfig;

    public MailServiceImpl(MailConfig mailConfig) {
        this.mailConfig = mailConfig;
    }

    @Override
    public EmailResponse sendMail(EmailRequest request) {
        final String apiKey = mailConfig.getMailApiKey();
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(APPLICATION_JSON);
        httpHeaders.set("accept" ,APPLICATION_JSON_VALUE);
        httpHeaders.set("api-key", apiKey);
        HttpEntity<EmailRequest> requestEntity = new RequestEntity<>(request, httpHeaders, POST, URI.create(mailConfig.getBrevoMailUrl()));
        ResponseEntity<EmailResponse> response =
                restTemplate.postForEntity(mailConfig.getBrevoMailUrl(),
                        requestEntity, EmailResponse.class);
        var emailResponse = response.getBody();
        emailResponse.setCode(response.getStatusCode().value());
        return emailResponse;
    }
}
