package miage.findlibrary.services;

import miage.findlibrary.entities.Sommet;
import miage.findlibrary.repositories.SommetRepository;
import miage.findlibrary.entities.Arrete;
import miage.findlibrary.models.ArreteImpl;
import miage.findlibrary.repositories.ArreteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class ArreteService {

    @Autowired
    public ArreteRepository arreteRepository;
    @Autowired
    public SommetRepository sommetRepository;

    public Arrete createArrete(ArreteImpl arreteImpl)
    {
        Arrete arrete = new Arrete();
        arrete.setPoids(arreteImpl.getPoids());
        arrete.setMesSommets(new HashSet<>());

        Set<Sommet> sommets = new HashSet<>();
        for(Long sId :  arreteImpl.getMesSommets())
        {
            sommets.add(this.sommetRepository.findById(sId).orElseThrow());
        }

        Arrete createdArrete = this.arreteRepository.save(arrete);
        createdArrete.getMesSommets().addAll(sommets);

        return this.arreteRepository.saveAndFlush(arrete);
    }

    public Arrete updateArret(ArreteImpl arreteImpl) {
        Arrete arrete = this.arreteRepository.findById(arreteImpl.getIdArrete()).orElseThrow();
        arrete.setPoids(arreteImpl.getPoids());
        arrete.setMesSommets(new HashSet<>());

        arreteImpl.getMesSommets().forEach( aId -> arrete.getMesSommets().add(this.sommetRepository.findById(aId).orElseThrow()));

        arrete.getMesSommets().forEach(ar -> {
            ar.getMesArretes().add(arrete);
            this.arreteRepository.saveAndFlush(arrete);
        });
        return this.arreteRepository.saveAndFlush(arrete);
    }

    public Set<Arrete> createManyArretes(List<ArreteImpl> arretes) {
        Set<Arrete> listArretes = new HashSet<>();
        arretes.forEach(arrete -> listArretes.add(this.createArrete(arrete)));
        return listArretes;
    }

    public void deleteArretetById(Long aId) {
        this.arreteRepository.deleteById(aId);
    }

    public Arrete getArreteById(Long aId)
    {
        return this.arreteRepository.findById(aId).orElseThrow();
    }

    public List<Arrete> getAllArretes()
    {
        return this.arreteRepository.findAll();
    }


}
