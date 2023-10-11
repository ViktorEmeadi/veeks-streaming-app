package africa.semicolon.veeksstreamingapp.data.dtos.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import org.springframework.stereotype.Service;

import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EmailRequest {
    private Sender sender;
    @JsonProperty("to")
    private List<Receiver> receiver;
    private String subject;
    @JsonProperty("htmlContent")
    private String content;

}
