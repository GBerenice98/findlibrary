package miage.findlibrary;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/api")
public class Biblio {

    @Autowired
    SommetService sommetService;
    @Autowired
    ArreteService arreteService;
    @Autowired
    CategorieService categorieService;

    //Categorie
    @PostMapping(value = "/createCategorie/{name}",consumes = "application/json",produces = "application/json")
    public Categorie createCategorie(@PathVariable String name)
    {
        return this.categorieService.createCategorie(name);
    }

    @PutMapping(value = "/updateCategorie", consumes = "application/json",produces = "application/json")
    public Categorie updateCategorie(@RequestBody Categorie categorie)
    {
        return  this.categorieService.updateCategorie(categorie);
    }

    @DeleteMapping(value = "/deleteCategorie/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public void deleteCategorie(@PathVariable Long id)
    {
        this.categorieService.deleteCategorie(id);
    }

    @GetMapping(value = "/getAllCategories", produces = MediaType.APPLICATION_JSON_VALUE)
    public Set<Categorie> getAllCategories()
    {
        return this.categorieService.getAllCategories();
    }

    @GetMapping(value = "/getAllSommetOfCategorie/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Set<Sommet> getAllSommetOfCategorie(@PathVariable Long id)
    {
        return this.categorieService.getAllSommetOfCategorie(id);
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

}
