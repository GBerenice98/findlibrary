package miage.findlibrary.repositories;

import miage.findlibrary.entities.Recherche;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RechercheRepository extends JpaRepository<Recherche,Long> {
    Optional<Recherche> findByNameIgnoreCase(String name);
}
