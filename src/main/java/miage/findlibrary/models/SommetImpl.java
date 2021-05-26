package miage.findlibrary.models;


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
    private Long idGraphe;
    private Long poids;
    private String name;
    @Builder.Default
    private Set<Long> mesArretes = new HashSet<>();

    public SommetImpl(String name, Long poids, Long idGraphe) {
        this.poids = poids;
        this.name = name;
        this.idGraphe = idGraphe;
    }
}
