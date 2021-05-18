package miage.findlibrary;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface SommetRepository extends JpaRepository<Sommet, Long> {

    Optional<Sommet> findByName(String name);
    List<Sommet> findByCategorie(Categorie categorie);
}
