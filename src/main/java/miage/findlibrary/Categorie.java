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
public class Categorie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCategorie;
    @Column(unique=true)
    private String name;
    @Builder.Default
    @OneToMany( cascade = CascadeType.ALL, mappedBy="categorie")
    @JsonIgnore
    private Set<Sommet> listSommets = new HashSet<>();

    public Categorie(){}

    public Categorie(String name) {
        this.name = name;
    }
}
