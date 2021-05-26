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
        List<Graphe> graphes = grapheRepository.findAll();
        List<Sommet> sommets = sommetRepository.findAll();
        List<Arrete> arretes = arreteRepository.findAll();

        if(graphes.isEmpty())
        {
            grapheRepository.save(new Graphe("Logging","./../assets/images/gMLogging.PNG"));
            grapheRepository.save(new Graphe("JSON","./../assets/images/gMJson.PNG"));
            log.info("--- Some graphes initialized");
        }

        // Sommets du graphe Logging
        String s1 = "sl4j";
        String s2="logback";
        String s3="commons-logging";
        String s4="log4j";

        //Sommets du graphe JSON
        String s5 = "jsonic";
        String s6 ="json-lib";
        String s7 ="fastjson";
        String s8 ="json-smart";
        String s9 ="jackson";
        String s10 ="gson";
        String s11="json-path";
        String s12="json-simple";
        String s13="org.json";
        String s14="svenson";
        String s15="xstream";
        String s16="jettison";
        String s17="flexjson";

        if(sommets.isEmpty())
        {
            // Sommets du graphe Logging
            sommetRepository.save(new Sommet(this.grapheRepository.findById(1L).orElseThrow(), s1, 130L));
            sommetRepository.save(new Sommet(this.grapheRepository.findById(1L).orElseThrow(),s2,19L));
            sommetRepository.save(new Sommet(this.grapheRepository.findById(1L).orElseThrow(),s3,-66L));
            sommetRepository.save(new Sommet(this.grapheRepository.findById(1L).orElseThrow(),s4,-83L));

            //Sommets du graphe JSON
            sommetRepository.save(new Sommet(this.grapheRepository.findById(2L).orElseThrow(),s5,1L));
            sommetRepository.save(new Sommet(this.grapheRepository.findById(2L).orElseThrow(),s6,-18L));
            sommetRepository.save(new Sommet(this.grapheRepository.findById(2L).orElseThrow(),s7,8L));
            sommetRepository.save(new Sommet(this.grapheRepository.findById(2L).orElseThrow(),s8,0L));
            sommetRepository.save(new Sommet(this.grapheRepository.findById(2L).orElseThrow(),s9,53L));
            sommetRepository.save(new Sommet(this.grapheRepository.findById(2L).orElseThrow(),s10,18L));
            sommetRepository.save(new Sommet(this.grapheRepository.findById(2L).orElseThrow(),s11,0L));
            sommetRepository.save(new Sommet(this.grapheRepository.findById(2L).orElseThrow(),s12,-9L));
            sommetRepository.save(new Sommet(this.grapheRepository.findById(2L).orElseThrow(),s13,-50L));
            sommetRepository.save(new Sommet(this.grapheRepository.findById(2L).orElseThrow(),s14,-1L));
            sommetRepository.save(new Sommet(this.grapheRepository.findById(2L).orElseThrow(),s15,-5L));
            sommetRepository.save(new Sommet(this.grapheRepository.findById(2L).orElseThrow(),s16,-2L));
            sommetRepository.save(new Sommet(this.grapheRepository.findById(2L).orElseThrow(),s17,5L));

            log.info("--- Some sommets initialized");
        }

        if(arretes.isEmpty()) {
            // Arretes du graphe Logging
            arreteRepository.save(new Arrete(6L,s1,
                    new HashSet<>(Arrays.asList(sommetRepository.findById(1L).orElseThrow(), sommetRepository.findById(3L).orElseThrow())),
                    this.grapheRepository.findById(1L).orElseThrow()));
            arreteRepository.save(new Arrete(19L,s1,
                    new HashSet<>(Arrays.asList(sommetRepository.findById(1L).orElseThrow(), sommetRepository.findById(4L).orElseThrow())),
                    this.grapheRepository.findById(1L).orElseThrow()));
            arreteRepository.save(new Arrete(1L,s2,
                    new HashSet<>(Arrays.asList(sommetRepository.findById(2L).orElseThrow(), sommetRepository.findById(1L).orElseThrow())),
                    this.grapheRepository.findById(1L).orElseThrow()));
            arreteRepository.save(new Arrete(1L,s2,
                    new HashSet<>(Arrays.asList(sommetRepository.findById(2L).orElseThrow(), sommetRepository.findById(4L).orElseThrow())),
                    this.grapheRepository.findById(1L).orElseThrow()));
            arreteRepository.save(new Arrete(61L,s3,
                    new HashSet<>(Arrays.asList(sommetRepository.findById(3L).orElseThrow(), sommetRepository.findById(1L).orElseThrow())),
                    this.grapheRepository.findById(1L).orElseThrow()));
            arreteRepository.save(new Arrete(9L,s3,
                    new HashSet<>(Arrays.asList(sommetRepository.findById(3L).orElseThrow(), sommetRepository.findById(2L).orElseThrow())),
                    this.grapheRepository.findById(1L).orElseThrow()));
            arreteRepository.save(new Arrete(17L,s3,
                    new HashSet<>(Arrays.asList(sommetRepository.findById(3L).orElseThrow(), sommetRepository.findById(4L).orElseThrow())),
                    this.grapheRepository.findById(1L).orElseThrow()));
            arreteRepository.save(new Arrete(95L,s4,
                    new HashSet<>(Arrays.asList(sommetRepository.findById(4L).orElseThrow(), sommetRepository.findById(1L).orElseThrow())),
                    this.grapheRepository.findById(1L).orElseThrow()));
            arreteRepository.save(new Arrete(13L,s4,
                    new HashSet<>(Arrays.asList(sommetRepository.findById(4L).orElseThrow(), sommetRepository.findById(2L).orElseThrow())),
                    this.grapheRepository.findById(1L).orElseThrow()));
            arreteRepository.save(new Arrete(12L,s4,
                    new HashSet<>(Arrays.asList(sommetRepository.findById(4L).orElseThrow(), sommetRepository.findById(3L).orElseThrow())),
                    this.grapheRepository.findById(1L).orElseThrow()));

            //Arretes du graphe JSON
            arreteRepository.save(new Arrete(11L,s6,
                    new HashSet<>(Arrays.asList(sommetRepository.findById(6L).orElseThrow(), sommetRepository.findById(9L).orElseThrow())),
                    this.grapheRepository.findById(2L).orElseThrow()));
            arreteRepository.save(new Arrete(5L,s6,
                    new HashSet<>(Arrays.asList(sommetRepository.findById(6L).orElseThrow(), sommetRepository.findById(10L).orElseThrow())),
                    this.grapheRepository.findById(2L).orElseThrow()));
            arreteRepository.save(new Arrete(2L,s9,
                    new HashSet<>(Arrays.asList(sommetRepository.findById(9L).orElseThrow(), sommetRepository.findById(6L).orElseThrow())),
                    this.grapheRepository.findById(2L).orElseThrow()));
            arreteRepository.save(new Arrete(5L,s9,
                    new HashSet<>(Arrays.asList(sommetRepository.findById(9L).orElseThrow(), sommetRepository.findById(7L).orElseThrow())),
                    this.grapheRepository.findById(2L).orElseThrow()));
            arreteRepository.save(new Arrete(8L,s9,
                    new HashSet<>(Arrays.asList(sommetRepository.findById(9L).orElseThrow(), sommetRepository.findById(10L).orElseThrow())),
                    this.grapheRepository.findById(2L).orElseThrow()));
            arreteRepository.save(new Arrete(4L,s9,
                    new HashSet<>(Arrays.asList(sommetRepository.findById(9L).orElseThrow(), sommetRepository.findById(12L).orElseThrow())),
                    this.grapheRepository.findById(2L).orElseThrow()));
            arreteRepository.save(new Arrete(8L,s9,
                    new HashSet<>(Arrays.asList(sommetRepository.findById(9L).orElseThrow(), sommetRepository.findById(13L).orElseThrow())),
                    this.grapheRepository.findById(2L).orElseThrow()));
            arreteRepository.save(new Arrete(6L,s10,
                    new HashSet<>(Arrays.asList(sommetRepository.findById(10L).orElseThrow(), sommetRepository.findById(7L).orElseThrow())),
                    this.grapheRepository.findById(2L).orElseThrow()));
            arreteRepository.save(new Arrete(22L,s10,
                    new HashSet<>(Arrays.asList(sommetRepository.findById(10L).orElseThrow(), sommetRepository.findById(9L).orElseThrow())),
                    this.grapheRepository.findById(2L).orElseThrow()));
            arreteRepository.save(new Arrete(8L,s12,
                    new HashSet<>(Arrays.asList(sommetRepository.findById(12L).orElseThrow(), sommetRepository.findById(10L).orElseThrow())),
                    this.grapheRepository.findById(2L).orElseThrow()));
            arreteRepository.save(new Arrete(26L,s13,
                    new HashSet<>(Arrays.asList(sommetRepository.findById(13L).orElseThrow(), sommetRepository.findById(9L).orElseThrow())),
                    this.grapheRepository.findById(2L).orElseThrow()));
            arreteRepository.save(new Arrete(28L,s13,
                    new HashSet<>(Arrays.asList(sommetRepository.findById(13L).orElseThrow(), sommetRepository.findById(10L).orElseThrow())),
                    this.grapheRepository.findById(2L).orElseThrow()));
            arreteRepository.save(new Arrete(6L,s15,
                    new HashSet<>(Arrays.asList(sommetRepository.findById(15L).orElseThrow(), sommetRepository.findById(10L).orElseThrow())),
                    this.grapheRepository.findById(2L).orElseThrow()));
            arreteRepository.save(new Arrete(8L,s17,
                    new HashSet<>(Arrays.asList(sommetRepository.findById(17L).orElseThrow(), sommetRepository.findById(9L).orElseThrow())),
                    this.grapheRepository.findById(2L).orElseThrow()));

            log.info("--- Some arretes initialized");
        }
    }
}
