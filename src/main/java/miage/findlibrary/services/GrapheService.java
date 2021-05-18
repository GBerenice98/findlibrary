package miage.findlibrary.services;

import miage.findlibrary.entities.Sommet;
import miage.findlibrary.repositories.SommetRepository;
import miage.findlibrary.entities.Graphe;
import miage.findlibrary.repositories.GrapheRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class GrapheService {

    @Autowired
    public GrapheRepository grapheRepository;
    @Autowired
    public SommetRepository sommetRepository;

    public Graphe createGraphe(Graphe graphe)
    {
        return this.grapheRepository.save(graphe);
    }

    public Graphe updateGraphe(Graphe g)
    {
        return this.grapheRepository.saveAndFlush(g);
    }

    public Set<Graphe> getAllGraphes()
    {
        return new HashSet<>(this.grapheRepository.findAll());
    }

    public Set<Sommet> getAllSommetOfGraphe(Long idC)
    {
        Graphe graphe = grapheRepository.findById(idC).orElseThrow();
        return new HashSet<>(this.sommetRepository.findByGraphe(graphe));
    }

    public void deleteGraphe(Long id)
    {
        this.grapheRepository.deleteById(id);
    }
}
