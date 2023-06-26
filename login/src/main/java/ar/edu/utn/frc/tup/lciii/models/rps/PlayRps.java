package ar.edu.utn.frc.tup.lciii.models.rps;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PlayRps {

    private Long id;
    private Long matchRpsId;
    private ShapeHand shapeHandPlayer1;
    private ShapeHand shapeHandlePlayer2;
    private Long winnerId;
}