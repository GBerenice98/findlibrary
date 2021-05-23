package miage.findlibrary;

import lombok.extern.slf4j.Slf4j;
import miage.findlibrary.entities.Arrete;
import miage.findlibrary.entities.Graphe;
import miage.findlibrary.entities.Sommet;
import miage.findlibrary.repositories.ArreteRepository;
import miage.findlibrary.repositories.GrapheRepository;
import miage.findlibrary.repositories.SommetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

@Slf4j
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
        log.info("DB initializes...");
        List<Graphe> categories = grapheRepository.findAll();
        List<Sommet> sommets = sommetRepository.findAll();
        List<Arrete> arretes = arreteRepository.findAll();

        if(categories.isEmpty())
        {
            grapheRepository.save(new Graphe("Logging","./../assets/images/gMLogging.PNG"));
            grapheRepository.save(new Graphe("JSON","./../assets/images/gMJson.PNG"));
            log.info("--- Some graphes initialized");
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

            log.info("--- Some sommets initialized");
        }

        if(arretes.isEmpty()) {
            // Arretes du graphe Logging
            arreteRepository.save(new Arrete(6L,
                    new HashSet<>(Arrays.asList(sommetRepository.findById(1L).orElseThrow(), sommetRepository.findById(3L).orElseThrow())),
                    this.grapheRepository.findById(1L).orElseThrow()));
            arreteRepository.save(new Arrete(19L,
                    new HashSet<>(Arrays.asList(sommetRepository.findById(1L).orElseThrow(), sommetRepository.findById(4L).orElseThrow())),
                    this.grapheRepository.findById(1L).orElseThrow()));
            arreteRepository.save(new Arrete(1L,
                    new HashSet<>(Arrays.asList(sommetRepository.findById(2L).orElseThrow(), sommetRepository.findById(1L).orElseThrow())),
                    this.grapheRepository.findById(1L).orElseThrow()));
            arreteRepository.save(new Arrete(1L,
                    new HashSet<>(Arrays.asList(sommetRepository.findById(2L).orElseThrow(), sommetRepository.findById(4L).orElseThrow())),
                    this.grapheRepository.findById(1L).orElseThrow()));
            arreteRepository.save(new Arrete(61L,
                    new HashSet<>(Arrays.asList(sommetRepository.findById(3L).orElseThrow(), sommetRepository.findById(1L).orElseThrow())),
                    this.grapheRepository.findById(1L).orElseThrow()));
            arreteRepository.save(new Arrete(9L,
                    new HashSet<>(Arrays.asList(sommetRepository.findById(3L).orElseThrow(), sommetRepository.findById(2L).orElseThrow())),
                    this.grapheRepository.findById(1L).orElseThrow()));
            arreteRepository.save(new Arrete(17L,
                    new HashSet<>(Arrays.asList(sommetRepository.findById(3L).orElseThrow(), sommetRepository.findById(4L).orElseThrow())),
                    this.grapheRepository.findById(1L).orElseThrow()));
            arreteRepository.save(new Arrete(95L,
                    new HashSet<>(Arrays.asList(sommetRepository.findById(4L).orElseThrow(), sommetRepository.findById(1L).orElseThrow())),
                    this.grapheRepository.findById(1L).orElseThrow()));
            arreteRepository.save(new Arrete(13L,
                    new HashSet<>(Arrays.asList(sommetRepository.findById(4L).orElseThrow(), sommetRepository.findById(2L).orElseThrow())),
                    this.grapheRepository.findById(1L).orElseThrow()));
            arreteRepository.save(new Arrete(12L,
                    new HashSet<>(Arrays.asList(sommetRepository.findById(4L).orElseThrow(), sommetRepository.findById(3L).orElseThrow())),
                    this.grapheRepository.findById(1L).orElseThrow()));

            //Arretes du graphe JSON
            arreteRepository.save(new Arrete(11L,
                    new HashSet<>(Arrays.asList(sommetRepository.findById(6L).orElseThrow(), sommetRepository.findById(9L).orElseThrow())),
                    this.grapheRepository.findById(2L).orElseThrow()));
            arreteRepository.save(new Arrete(5L,
                    new HashSet<>(Arrays.asList(sommetRepository.findById(6L).orElseThrow(), sommetRepository.findById(10L).orElseThrow())),
                    this.grapheRepository.findById(2L).orElseThrow()));
            arreteRepository.save(new Arrete(2L,
                    new HashSet<>(Arrays.asList(sommetRepository.findById(9L).orElseThrow(), sommetRepository.findById(6L).orElseThrow())),
                    this.grapheRepository.findById(2L).orElseThrow()));
            arreteRepository.save(new Arrete(5L,
                    new HashSet<>(Arrays.asList(sommetRepository.findById(9L).orElseThrow(), sommetRepository.findById(7L).orElseThrow())),
                    this.grapheRepository.findById(2L).orElseThrow()));
            arreteRepository.save(new Arrete(8L,
                    new HashSet<>(Arrays.asList(sommetRepository.findById(9L).orElseThrow(), sommetRepository.findById(10L).orElseThrow())),
                    this.grapheRepository.findById(2L).orElseThrow()));
            arreteRepository.save(new Arrete(4L,
                    new HashSet<>(Arrays.asList(sommetRepository.findById(9L).orElseThrow(), sommetRepository.findById(12L).orElseThrow())),
                    this.grapheRepository.findById(2L).orElseThrow()));
            arreteRepository.save(new Arrete(8L,
                    new HashSet<>(Arrays.asList(sommetRepository.findById(9L).orElseThrow(), sommetRepository.findById(13L).orElseThrow())),
                    this.grapheRepository.findById(2L).orElseThrow()));
            arreteRepository.save(new Arrete(6L,
                    new HashSet<>(Arrays.asList(sommetRepository.findById(10L).orElseThrow(), sommetRepository.findById(7L).orElseThrow())),
                    this.grapheRepository.findById(2L).orElseThrow()));
            arreteRepository.save(new Arrete(22L,
                    new HashSet<>(Arrays.asList(sommetRepository.findById(10L).orElseThrow(), sommetRepository.findById(9L).orElseThrow())),
                    this.grapheRepository.findById(2L).orElseThrow()));
            arreteRepository.save(new Arrete(8L,
                    new HashSet<>(Arrays.asList(sommetRepository.findById(12L).orElseThrow(), sommetRepository.findById(10L).orElseThrow())),
                    this.grapheRepository.findById(2L).orElseThrow()));
            arreteRepository.save(new Arrete(26L,
                    new HashSet<>(Arrays.asList(sommetRepository.findById(13L).orElseThrow(), sommetRepository.findById(9L).orElseThrow())),
                    this.grapheRepository.findById(2L).orElseThrow()));
            arreteRepository.save(new Arrete(28L,
                    new HashSet<>(Arrays.asList(sommetRepository.findById(13L).orElseThrow(), sommetRepository.findById(10L).orElseThrow())),
                    this.grapheRepository.findById(2L).orElseThrow()));
            arreteRepository.save(new Arrete(6L,
                    new HashSet<>(Arrays.asList(sommetRepository.findById(15L).orElseThrow(), sommetRepository.findById(10L).orElseThrow())),
                    this.grapheRepository.findById(2L).orElseThrow()));
            arreteRepository.save(new Arrete(8L,
                    new HashSet<>(Arrays.asList(sommetRepository.findById(17L).orElseThrow(), sommetRepository.findById(9L).orElseThrow())),
                    this.grapheRepository.findById(2L).orElseThrow()));

            log.info("--- Some arretes initialized");
        }
    }
}
