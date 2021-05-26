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
public class ArreteImpl {

    private Long idArrete;
    private Long poids;
    private Long idDirection;
    private Set<Long> mesSommets = new HashSet<>();

    public ArreteImpl(Long poids, Set<Long> mesSommets, Long idDirection) {
        this.poids = poids;
        this.mesSommets = mesSommets;
        this.idDirection=idDirection;
    }
}
