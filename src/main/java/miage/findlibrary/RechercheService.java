package miage.findlibrary;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class RechercheService {

    @Autowired
    private RechercheRepository rechercheRepository;

    public Recherche createRecherche(Recherche recherche)
    {
        Optional<Recherche> receiveRecherche=this.rechercheRepository.findByName(recherche.getName());
        if(receiveRecherche.isPresent())
        {
            receiveRecherche.get().setNb();
            return this.rechercheRepository.saveAndFlush(receiveRecherche.get());
        }
        else return this.rechercheRepository.save(recherche);
    }

    public Recherche getRechercheByName(String name)
    {
        return this.rechercheRepository.findByName(name).orElseThrow();
    }

    public Set<Recherche> getAllRecherches()
    {
        return new HashSet<>(this.rechercheRepository.findAll());
    }

    public void deleteRechercheById(Long id)
    {
        this.rechercheRepository.deleteById(id);
    }

}
