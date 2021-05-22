package miage.findlibrary.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import miage.findlibrary.entities.Arrete;
import miage.findlibrary.entities.Graphe;

import javax.persistence.*;
import java.util.Set;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Sommet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idSommet;
    private Long poids;
    @Column(unique=true)
    private String name;
    @JsonIgnore
    @ManyToMany(mappedBy = "mesSommets",fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    private Set<Arrete> mesArretes;
    @JsonIgnore
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idGraphe")
    private Graphe graphe;

    public Sommet(Graphe graphe, String name, Long poids) {
        this.graphe = graphe;
        this.poids = poids;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Sommet{" +
                "idSommet=" + idSommet +
                ", poids=" + poids +
                ", name='" + name + '\'' +
                '}';
    }
}
