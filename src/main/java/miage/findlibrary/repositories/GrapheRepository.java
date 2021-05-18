package miage.findlibrary.repositories;

import miage.findlibrary.entities.Graphe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GrapheRepository extends JpaRepository<Graphe,Long> {
}
