package miage.findlibrary.models;

import lombok.*;


@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class RechercheDto {
    private Long idRecherche;
    private String name;
    private Long nb;
}


