package africa.semicolon.veeksstreamingapp.data.dtos.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
public class EmailResponse {
    private Long messageId;
    private int code;
}
