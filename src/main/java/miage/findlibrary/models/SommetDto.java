package miage.findlibrary.models;


import lombok.*;
import miage.findlibrary.entities.Arrete;
import miage.findlibrary.entities.Graphe;

import java.util.Set;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class SommetDto {

    private Long idSommet;
    private Long poids;
    private String name;
    private Set<Arrete> mesArretes;
    private Graphe graphe;
}
