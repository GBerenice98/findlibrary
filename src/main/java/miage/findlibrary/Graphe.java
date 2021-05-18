package miage.findlibrary;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Setter
@Getter
@AllArgsConstructor
@ToString
public class Graphe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idGraphe;
    @Column(unique=true)
    private String name;
    private String url;
    @Builder.Default
    @OneToMany( cascade = CascadeType.ALL, mappedBy="graphe")
    @JsonIgnore
    private Set<Sommet> listSommets = new HashSet<>();
    @Builder.Default
    @OneToMany( cascade = CascadeType.ALL, mappedBy="graphe")
    @JsonIgnore
    private Set<Arrete> listArretes = new HashSet<>();

    public Graphe(){}

    public Graphe(String name, String url) {
        this.name = name;
        this.url = url;
    }
}
