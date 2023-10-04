package africa.semicolon.veeksstreamingapp.data.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "Users")
public class User {
    private String email;
    private String passwords;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
}
