package miage.findlibrary.services;

import lombok.extern.slf4j.Slf4j;
import miage.findlibrary.entities.Arrete;
import miage.findlibrary.entities.Graphe;
import miage.findlibrary.entities.Sommet;
import miage.findlibrary.models.SommetImpl;
import miage.findlibrary.repositories.ArreteRepository;
import miage.findlibrary.repositories.GrapheRepository;
import miage.findlibrary.repositories.SommetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Slf4j
@Service
public class SommetService {

    @Autowired
    private SommetRepository sommetRepository;
    @Autowired
    private ArreteRepository arreteRepository;
    @Autowired
    private GrapheRepository grapheRepository;
    @Autowired
    private GrapheService grapheService;

    public Sommet createSommet(SommetImpl s)
    {
        log.info("Received sommet {} ",s);
        Graphe graphe = grapheRepository.findById(s.getIdGraphe()).orElseThrow();
        Sommet sommet = new Sommet(graphe,s.getName(),s.getPoids());
        sommet.setMesArretes(new HashSet<>());
        return this.sommetRepository.save(sommet);
    }

    public Sommet updateSommet(SommetImpl s)
    {
        Sommet sommet = this.sommetRepository.findById(s.getIdSommet()).orElseThrow();
        sommet.setGraphe(grapheRepository.findById(s.getIdGraphe()).orElseThrow());
        sommet.setName(s.getName());
        sommet.setPoids(s.getPoids());
        sommet.setMesArretes(new HashSet<>());

        s.getMesArretes().forEach( aId -> sommet.getMesArretes().add(this.arreteRepository.findById(aId).orElseThrow()));

        sommet.getMesArretes().forEach(arrete -> {
            arrete.getMesSommets().add(sommet);
            this.arreteRepository.saveAndFlush(arrete);
        });

        return this.sommetRepository.saveAndFlush(sommet);
    }

    public Set<Sommet> createManySommet(List<SommetImpl> sommets) {
        Set<Sommet> listSommets = new HashSet<>();
        sommets.forEach(sImpl -> listSommets.add(this.createSommet(sImpl)));
        return listSommets;
    }

    public void deleteSommetById(Long sId) {
        this.sommetRepository.deleteById(sId);
    }

    public Sommet getSommetById(Long aId) {
        return this.sommetRepository.findById(aId).orElseThrow();
    }

    public List<Sommet> getAllSommets() {
        return this.sommetRepository.findAll();
    }

    public Set<Sommet> findLibraryCandidates(String name)
    {
        log.info("Name received : "+name);
        Sommet source = this.sommetRepository.findByNameIgnoreCase(name).orElseThrow();

        log.info("Sommet source : "+source);

        List<Arrete> arretes = this.arreteRepository.findBySourceNameIgnoreCase(name);
        Set<Sommet> cibles = new HashSet<>();

        log.info("Arretes contenant source : "+arretes.toString());

        arretes.forEach(a -> a.getMesSommets().forEach(s -> {
            if(!source.getName().equalsIgnoreCase(s.getName()) && s.getPoids()>0) cibles.add(s);
        }));

        log.info("Sommets cibles : "+cibles);
        return cibles;
    }

    public boolean libraryIsExist(String name, Long id) {
        Set<Sommet> sommets = this.grapheService.getAllSommetOfGraphe(id)
                            .stream()
                            .filter(sommet -> sommet.getName().equalsIgnoreCase(name)).collect(Collectors.toSet());

        log.info("sommets {}",sommets);
        return !sommets.isEmpty();
    }
}
