package miage.findlibrary.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import miage.findlibrary.entities.Arrete;
import miage.findlibrary.entities.Sommet;

import java.util.Set;

@Setter
@Getter
@AllArgsConstructor
@ToString
public class GrapheDto {

    private Long idGraphe;
    private String name;
    private String url;
    private Set<Sommet> listSommets ;
    private Set<Arrete> listArretes;
}
