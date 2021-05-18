package miage.findlibrary;

import miage.findlibrary.entities.Arrete;
import miage.findlibrary.entities.Graphe;
import miage.findlibrary.entities.Sommet;
import miage.findlibrary.repositories.ArreteRepository;
import miage.findlibrary.repositories.GrapheRepository;
import miage.findlibrary.repositories.SommetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DbInitializer implements CommandLineRunner {

    @Autowired
    GrapheRepository grapheRepository;
    @Autowired
    SommetRepository sommetRepository;
    @Autowired
    ArreteRepository arreteRepository;

    @Override
    public void run(String... args) {
        System.out.println("DB initializes...");
        List<Graphe> categories = grapheRepository.findAll();
        List<Sommet> sommets = sommetRepository.findAll();
        List<Arrete> arretes = arreteRepository.findAll();

        if(categories.isEmpty())
        {
            grapheRepository.save(new Graphe("Logging","./../assets/images/gMLogging.PNG"));
            grapheRepository.save(new Graphe("JSON","./../assets/images/gMJson.PNG"));
            System.out.println("--- Some graphes initialized");
        }

        if(sommets.isEmpty())
        {
            sommetRepository.save(new Sommet(this.grapheRepository.findById(1L).orElseThrow(),"sl4j",130L));
            sommetRepository.save(new Sommet(this.grapheRepository.findById(1L).orElseThrow(),"logback",19L));
            sommetRepository.save(new Sommet(this.grapheRepository.findById(1L).orElseThrow(),"commons-logging",-66L));
            sommetRepository.save(new Sommet(this.grapheRepository.findById(1L).orElseThrow(),"log4j",-83L));
            System.out.println("--- Some sommets initialized");
        }
    }
}
