package miage.findlibrary;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Arrete {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idArrete;
    private Long poids;
    @ManyToMany(fetch =  FetchType.EAGER)
    @JoinTable(name = "sommet_arrete",
            joinColumns = @JoinColumn(name = "idSommet"),
            inverseJoinColumns = @JoinColumn(name = "idArrete"))
    private Set<Sommet> mesSommets = new HashSet<>();

//    @Override
//    public String toString() {
//        return "Arrete{" +
//                "idArrete=" + idArrete +
//                ", poids=" + poids +
//                '}';
//    }
}
