package miage.findlibrary;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class CategorieService {

    @Autowired
    public CategorieRepository categorieRepository;
    @Autowired
    public SommetRepository sommetRepository;

    public Categorie createCategorie(String name)
    {
        return this.categorieRepository.save(new Categorie(name));
    }

    public Categorie updateCategorie(Categorie c)
    {
        return this.categorieRepository.saveAndFlush(c);
    }

    public Set<Categorie> getAllCategories()
    {
        return new HashSet<>(this.categorieRepository.findAll());
    }

    public Set<Sommet> getAllSommetOfCategorie(Long idC)
    {
        Categorie categorie = categorieRepository.findById(idC).orElseThrow();
        return new HashSet<>(this.sommetRepository.findByCategorie(categorie));
    }

    public void deleteCategorie(Long id)
    {
        this.categorieRepository.deleteById(id);
    }
}
