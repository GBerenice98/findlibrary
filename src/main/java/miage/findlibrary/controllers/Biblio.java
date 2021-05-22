package miage.findlibrary.controllers;

import miage.findlibrary.entities.Arrete;
import miage.findlibrary.entities.Graphe;
import miage.findlibrary.entities.Recherche;
import miage.findlibrary.entities.Sommet;
import miage.findlibrary.models.ArreteImpl;
import miage.findlibrary.models.SommetImpl;
import miage.findlibrary.services.ArreteService;
import miage.findlibrary.services.GrapheService;
import miage.findlibrary.services.RechercheService;
import miage.findlibrary.services.SommetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@CrossOrigin(origins="*")
@RestController
@RequestMapping("/api")
public class Biblio {

    @Autowired
    SommetService sommetService;
    @Autowired
    ArreteService arreteService;
    @Autowired
    GrapheService grapheService;
    @Autowired
    RechercheService rechercheService;

    //Graphe
    @PostMapping(value = "/createGraphe/{name}",consumes = "application/json",produces = "application/json")
    public Graphe createGraphe(@RequestBody Graphe graphe)
    {
        return this.grapheService.createGraphe(graphe);
    }

    @PutMapping(value = "/updateGraphe", consumes = "application/json",produces = "application/json")
    public Graphe updateGraphe(@RequestBody Graphe graphe)
    {
        return  this.grapheService.updateGraphe(graphe);
    }

    @DeleteMapping(value = "/deleteGraphe/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public void deleteGraphe(@PathVariable Long id)
    {
        this.grapheService.deleteGraphe(id);
    }

    @GetMapping(value = "/getAllGraphes", produces = MediaType.APPLICATION_JSON_VALUE)
    public Set<Graphe> getAllGraphes()
    {
        return this.grapheService.getAllGraphes();
    }

    @GetMapping(value = "/getAllSommetOfGraphe/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Set<Sommet> getAllSommetOfGraphe(@PathVariable Long id)
    {
        return this.grapheService.getAllSommetOfGraphe(id);
    }

    // Sommets
    @PostMapping(value = "/createSommet",consumes = "application/json",produces = "application/json")
    public Sommet createSommet(@RequestBody SommetImpl sommetImpl)
    {
        return this.sommetService.createSommet(sommetImpl);
    }

    @PostMapping(value = "/createManySommets",consumes = "application/json",produces = "application/json")
    public Set<Sommet> createManySommets(@RequestBody List<SommetImpl> sommets)
    {
        return this.sommetService.createManySommet(sommets);
    }

    @PutMapping(value = "/updateSommet", consumes = "application/json",produces = "application/json")
    public Sommet updateSommet(@RequestBody Sommet sommet)
    {
        return  this.sommetService.updateSommet(sommet);
    }

    @DeleteMapping(value = "/deleteSommet/{sId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public void deleteSommet(@PathVariable Long sId)
    {
        this.sommetService.deleteSommetById(sId);
    }

    @GetMapping(value = "/getSommetById/{aId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Sommet getSommetById(@PathVariable Long aId)
    {
        return this.sommetService.getSommetById(aId);
    }

    @GetMapping(value = "/isExist/{id}/{name}", produces = MediaType.APPLICATION_JSON_VALUE)
    public boolean getSommetById(@PathVariable String name, @PathVariable Long id)
    {
        return this.sommetService.libraryIsExist(name,id);
    }

    @GetMapping(value = "/getAllSommets", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Sommet> getAllSommets()
    {
        return this.sommetService.getAllSommets();
    }

    //Arrêtes
    @PostMapping(value = "/createArrete",consumes = "application/json",produces = "application/json")
    public Arrete createArrete(@RequestBody ArreteImpl arreteImpl)
    {
        return this.arreteService.createArrete(arreteImpl);
    }

    @PostMapping(value = "/createManyArretes",consumes = "application/json",produces = "application/json")
    public Set<Arrete> createManyArretes(@RequestBody List<ArreteImpl> arretes)
    {
        return this.arreteService.createManyArretes(arretes);
    }

    @PutMapping(value = "/updateArrete", consumes = "application/json",produces = "application/json")
    public Arrete updateArrete(ArreteImpl arreteImpl)
    {
        return  this.arreteService.updateArret(arreteImpl);
    }

    @DeleteMapping(value = "/deleteArrete/{aId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public void deleteArrete(@PathVariable Long aId)
    {
        this.arreteService.deleteArretetById(aId);
    }

    @GetMapping(value = "/getArreteById/{aId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Arrete getArreteById(@PathVariable Long aId)
    {
        return this.arreteService.getArreteById(aId);
    }

    @GetMapping(value = "/getAllArretes", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Arrete> getAllArretes()
    {
        return this.arreteService.getAllArretes();
    }

    @GetMapping(value = "/getCibles/{name}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Set<Sommet> findLibraryCandidates(@PathVariable String name)
    {
        return this.sommetService.findLibraryCandidates(name);
    }

    //Recherche
    @PostMapping(value = "/createRecherche",consumes = "application/json",produces = "application/json")
    public Recherche createRecherche(@RequestBody Recherche recherche)
    {
        return this.rechercheService.createRecherche(recherche);
    }

    @GetMapping(value = "/getRechercheByName/{name}", consumes = "application/json",produces = "application/json")
    public Recherche getRechercheByName(@PathVariable String name)
    {
        return  this.rechercheService.getRechercheByName(name);
    }

    @DeleteMapping(value = "/deleteRecherche/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public void deleteRechercheById(@PathVariable Long id)
    {
        this.rechercheService.deleteRechercheById(id);
    }

    @GetMapping(value = "/getAllRecherches", produces = MediaType.APPLICATION_JSON_VALUE)
    public Set<Recherche> getAllRecherches()
    {
        return this.rechercheService.getAllRecherches();
    }

}
