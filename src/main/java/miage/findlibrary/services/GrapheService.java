package miage.findlibrary.services;

import miage.findlibrary.entities.Sommet;
import miage.findlibrary.models.GrapheDto;
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

    public Graphe createGraphe(GrapheDto g)
    {
        return this.grapheRepository.save(new Graphe(g.getName(), g.getUrl()));
    }

    public Graphe updateGraphe(GrapheDto g)
    {
        Graphe updatedGraphe = this.grapheRepository.findById(g.getIdGraphe()).orElseThrow();
        updatedGraphe.setName(g.getName());
        updatedGraphe.setUrl(g.getUrl());
        updatedGraphe.setListSommets(g.getListSommets());
        updatedGraphe.setListArretes(g.getListArretes());

        return this.grapheRepository.saveAndFlush(updatedGraphe);
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
