package miage.findlibrary;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DbInitializer implements CommandLineRunner {

    @Autowired
    CategorieRepository categorieRepository;

    @Override
    public void run(String... args) {
        System.out.println("DB initializes...");
        List<Categorie> categories = categorieRepository.findAll();

        if(categories.isEmpty())
        {
            categorieRepository.save(new Categorie("Logging"));
            categorieRepository.save(new Categorie("JSON"));
            System.out.println("--- Some categories initialized");
        }
    }
}
