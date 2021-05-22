package miage.findlibrary.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Arrete {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idArrete;
    private Long poids;
    @JsonIgnore
    @ManyToMany(fetch =  FetchType.EAGER)
    @JoinTable(name = "sommet_arrete",
            joinColumns = @JoinColumn(name = "idSommet"),
            inverseJoinColumns = @JoinColumn(name = "idArrete"))
    private Set<Sommet> mesSommets = new HashSet<>();
    @JsonIgnore
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idGraphe")
    private Graphe graphe;

    public Arrete(Long poids, Set<Sommet> mesSommets, Graphe graphe) {
        this.poids = poids;
        this.mesSommets = mesSommets;
        this.graphe = graphe;
    }

    @Override
    public String toString() {
        return "Arrete{" +
                "idArrete=" + idArrete +
                ", poids=" + poids +
                '}';
    }
}
