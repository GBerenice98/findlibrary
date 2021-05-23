package miage.findlibrary.services;

import lombok.extern.slf4j.Slf4j;
import miage.findlibrary.models.SommetImpl;
import miage.findlibrary.repositories.SommetRepository;
import miage.findlibrary.entities.Arrete;
import miage.findlibrary.entities.Graphe;
import miage.findlibrary.entities.Sommet;
import miage.findlibrary.repositories.ArreteRepository;
import miage.findlibrary.repositories.GrapheRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
        Sommet sommet = new Sommet(graphe, s.getName(),s.getPoids());
        sommet.setMesArretes(new HashSet<>());
        return this.sommetRepository.save(sommet);
    }

    public Sommet updateSommet(Sommet s)
    {
        Sommet sommet = this.sommetRepository.findById(s.getIdSommet()).orElseThrow();
        sommet.setGraphe(s.getGraphe());
        sommet.setName(s.getName());
        sommet.setPoids(s.getPoids());
        sommet.setMesArretes(new HashSet<>());

        s.getMesArretes().forEach( aId -> sommet.getMesArretes().add(this.arreteRepository.findById(aId.getIdArrete()).orElseThrow()));

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
        Sommet source = this.sommetRepository.findByName(name).orElseThrow();

        log.info("Sommet source : "+source);

        List<Arrete> arretes = new ArrayList<>();
        Set<Sommet> cibles = new HashSet<>();

        this.arreteRepository.findAll().forEach( arrete -> {
            if(arrete.getMesSommets().contains(source)) arretes.add(arrete);
        });

        log.info("Arretes contenant source : "+arretes.toString());

        arretes.forEach(a -> a.getMesSommets().forEach(s -> {
            if(!source.getName().equals(s.getName()) && s.getPoids()>0) cibles.add(s);
        }));

        log.info("Sommets cibles : "+cibles);
        return cibles;
    }

    public boolean libraryIsExist(String name, Long id) {
        Set<Sommet> sommets = this.grapheService.getAllSommetOfGraphe(id)
                            .stream()
                            .filter(sommet -> sommet.getName().equals(name)).collect(Collectors.toSet());

        log.info("sommets");
        return !sommets.isEmpty();
    }
}
