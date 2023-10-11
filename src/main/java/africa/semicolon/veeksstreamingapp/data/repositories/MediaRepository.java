package africa.semicolon.veeksstreamingapp.data.repositories;

import africa.semicolon.veeksstreamingapp.data.models.Media;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MediaRepository extends JpaRepository<Media, Long> {
}
