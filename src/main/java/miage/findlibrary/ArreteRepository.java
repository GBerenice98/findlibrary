package miage.findlibrary;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArreteRepository extends JpaRepository<Arrete,Long> {
}
