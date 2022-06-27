package musicdb.repository;

import musicdb.model.AlbumEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;
import java.util.List;

@Repository
public interface AlbumRepository extends JpaRepository<AlbumEntity, Long> {

List<AlbumEntity> findAll();
    @Query("select sum(a.copies) from AlbumEntity a")
    BigInteger findTotalSoldCopies();
}
