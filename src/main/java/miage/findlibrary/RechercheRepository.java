package miage.findlibrary;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RechercheRepository extends JpaRepository<Recherche,Long> {
    Optional<Recherche> findByName(String name);
}
