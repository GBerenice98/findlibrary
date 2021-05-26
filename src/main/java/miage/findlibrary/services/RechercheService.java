package miage.findlibrary.services;

import miage.findlibrary.entities.Recherche;
import miage.findlibrary.models.RechercheDto;
import miage.findlibrary.repositories.RechercheRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class RechercheService {

    @Autowired
    private RechercheRepository rechercheRepository;

    public Recherche createRecherche(RechercheDto rechercheDto)
    {
        Optional<Recherche> receiveRecherche=this.rechercheRepository.findByNameIgnoreCase(rechercheDto.getName());
        if(receiveRecherche.isPresent())
        {
            receiveRecherche.get().setNb();
            return this.rechercheRepository.saveAndFlush(receiveRecherche.get());
        }
        else return this.rechercheRepository.save(new Recherche(rechercheDto.getName(), rechercheDto.getNb()));
    }

    public Recherche getRechercheByName(String name)
    {
        return this.rechercheRepository.findByNameIgnoreCase(name).orElseThrow();
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
