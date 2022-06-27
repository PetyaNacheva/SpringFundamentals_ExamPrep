package musicdb.repository;

import musicdb.model.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {

    Optional<UserEntity>findByUsernameAndPassword(String username, String password);
    UserEntity findByUsernameAndEmail(String username, String email);
}
