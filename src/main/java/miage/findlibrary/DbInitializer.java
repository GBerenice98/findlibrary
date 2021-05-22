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

import java.util.*;
import java.util.stream.Collectors;

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
            // Sommets du graphe Logging
            sommetRepository.save(new Sommet(this.grapheRepository.findById(1L).orElseThrow(),"sl4j",130L));
            sommetRepository.save(new Sommet(this.grapheRepository.findById(1L).orElseThrow(),"logback",19L));
            sommetRepository.save(new Sommet(this.grapheRepository.findById(1L).orElseThrow(),"commons-logging",-66L));
            sommetRepository.save(new Sommet(this.grapheRepository.findById(1L).orElseThrow(),"log4j",-83L));

            //Sommets du graphe JSON
            sommetRepository.save(new Sommet(this.grapheRepository.findById(2L).orElseThrow(),"jsonic",1L));
            sommetRepository.save(new Sommet(this.grapheRepository.findById(2L).orElseThrow(),"json-lib",-18L));
            sommetRepository.save(new Sommet(this.grapheRepository.findById(2L).orElseThrow(),"fastjson",8L));
            sommetRepository.save(new Sommet(this.grapheRepository.findById(2L).orElseThrow(),"json-smart",0L));
            sommetRepository.save(new Sommet(this.grapheRepository.findById(2L).orElseThrow(),"jackson",53L));
            sommetRepository.save(new Sommet(this.grapheRepository.findById(2L).orElseThrow(),"gson",18L));
            sommetRepository.save(new Sommet(this.grapheRepository.findById(2L).orElseThrow(),"json-path",0L));
            sommetRepository.save(new Sommet(this.grapheRepository.findById(2L).orElseThrow(),"json-simple",-9L));
            sommetRepository.save(new Sommet(this.grapheRepository.findById(2L).orElseThrow(),"org.json",-50L));
            sommetRepository.save(new Sommet(this.grapheRepository.findById(2L).orElseThrow(),"svenson",-1L));
            sommetRepository.save(new Sommet(this.grapheRepository.findById(2L).orElseThrow(),"xstream",-5L));
            sommetRepository.save(new Sommet(this.grapheRepository.findById(2L).orElseThrow(),"jettison",-2L));
            sommetRepository.save(new Sommet(this.grapheRepository.findById(2L).orElseThrow(),"flexjson",5L));

            System.out.println("--- Some sommets initialized");
        }

        if(arretes.isEmpty())
        {
            // Arretes du graphe Logging
            arreteRepository.save(new Arrete(6L,
                    new HashSet<Sommet>(Arrays.asList(sommetRepository.findById(1L).orElseThrow(), sommetRepository.findById(3L).orElseThrow())),
                    this.grapheRepository.findById(1L).orElseThrow()));
            arreteRepository.save(new Arrete(19L,
                    new HashSet<Sommet>(Arrays.asList(sommetRepository.findById(1L).orElseThrow(), sommetRepository.findById(4L).orElseThrow())),
                    this.grapheRepository.findById(1L).orElseThrow()));
            arreteRepository.save(new Arrete(1L,
                    new HashSet<Sommet>(Arrays.asList(sommetRepository.findById(2L).orElseThrow(), sommetRepository.findById(1L).orElseThrow())),
                    this.grapheRepository.findById(1L).orElseThrow()));
            arreteRepository.save(new Arrete(1L,
                    new HashSet<Sommet>(Arrays.asList(sommetRepository.findById(2L).orElseThrow(), sommetRepository.findById(4L).orElseThrow())),
                    this.grapheRepository.findById(1L).orElseThrow()));
            arreteRepository.save(new Arrete(61L,
                    new HashSet<Sommet>(Arrays.asList(sommetRepository.findById(3L).orElseThrow(), sommetRepository.findById(1L).orElseThrow())),
                    this.grapheRepository.findById(1L).orElseThrow()));
            arreteRepository.save(new Arrete(9L,
                    new HashSet<Sommet>(Arrays.asList(sommetRepository.findById(3L).orElseThrow(), sommetRepository.findById(2L).orElseThrow())),
                    this.grapheRepository.findById(1L).orElseThrow()));
            arreteRepository.save(new Arrete(17L,
                    new HashSet<Sommet>(Arrays.asList(sommetRepository.findById(3L).orElseThrow(), sommetRepository.findById(4L).orElseThrow())),
                    this.grapheRepository.findById(1L).orElseThrow()));
            arreteRepository.save(new Arrete(95L,
                    new HashSet<Sommet>(Arrays.asList(sommetRepository.findById(4L).orElseThrow(), sommetRepository.findById(1L).orElseThrow())),
                    this.grapheRepository.findById(1L).orElseThrow()));
            arreteRepository.save(new Arrete(13L,
                    new HashSet<Sommet>(Arrays.asList(sommetRepository.findById(4L).orElseThrow(), sommetRepository.findById(2L).orElseThrow())),
                    this.grapheRepository.findById(1L).orElseThrow()));
            arreteRepository.save(new Arrete(12L,
                    new HashSet<Sommet>(Arrays.asList(sommetRepository.findById(4L).orElseThrow(), sommetRepository.findById(3L).orElseThrow())),
                    this.grapheRepository.findById(1L).orElseThrow()));

            //Sommets du graphe JSON


            System.out.println("--- Some arretes initialized");
        }


    }
}
