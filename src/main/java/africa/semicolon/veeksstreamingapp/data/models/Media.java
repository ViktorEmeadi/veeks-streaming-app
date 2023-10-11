package africa.semicolon.veeksstreamingapp.data.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

import static jakarta.persistence.GenerationType.AUTO;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Media")
public class Media {
    @Id
    @GeneratedValue(strategy = AUTO)
    private Long id;
    private String title;
    private String description;
    private String url;
    private LocalDate dateUploaded;
    @OneToOne(fetch = FetchType.EAGER)
    private User uploader;
}
