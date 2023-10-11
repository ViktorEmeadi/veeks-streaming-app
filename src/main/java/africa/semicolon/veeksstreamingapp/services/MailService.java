package africa.semicolon.veeksstreamingapp.services;

import africa.semicolon.veeksstreamingapp.data.dtos.request.EmailRequest;
import africa.semicolon.veeksstreamingapp.data.dtos.response.EmailResponse;

public interface MailService {
    EmailResponse sendMail(EmailRequest request);
}
