package miage.findlibrary;


import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class SommetImpl {

    private Long idSommet;
    private Long idCategorie;
    private Long poids;
    private String name;
    @Builder.Default
    private Set<Long> mesArretes = new HashSet<>();

    public SommetImpl(String name,Long poids, Long idCategorie) {
        this.poids = poids;
        this.name = name;
        this.idCategorie=idCategorie;
    }
}
