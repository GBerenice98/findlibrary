package miage.findlibrary;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SommetRepository extends JpaRepository<Sommet, Long> {

    Sommet findByName(String name);
    List<Sommet> findByCategorie(Categorie categorie);
}
