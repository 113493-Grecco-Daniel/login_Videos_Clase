package ar.edu.utn.frc.tup.lciii.dtos.match;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MatchDTO {
    @NotNull
    private Long gameId;
    @NotNull
    private Long playerId;
}
