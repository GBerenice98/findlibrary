package miage.findlibrary.repositories;

import miage.findlibrary.entities.Graphe;
import miage.findlibrary.entities.Sommet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface SommetRepository extends JpaRepository<Sommet, Long> {

    Optional<Sommet> findByNameIgnoreCase(String name);
    List<Sommet> findByGraphe(Graphe graphe);
}
