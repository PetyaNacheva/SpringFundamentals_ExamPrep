package musicdb.repository;

import musicdb.model.ArtistEntity;
import musicdb.model.enums.ArtistEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ArtistRepository extends JpaRepository<ArtistEntity, Long> {
    Optional<ArtistEntity> findByName(ArtistEnum name);
}
