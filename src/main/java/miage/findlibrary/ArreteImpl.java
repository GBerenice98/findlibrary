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
public class ArreteImpl {

    private Long idArrete;
    private Long poids;
    private Set<Long> mesSommets = new HashSet<>();

    public ArreteImpl(Long poids, Set<Long> mesSommets) {
        this.poids = poids;
        this.mesSommets = mesSommets;
    }
}
