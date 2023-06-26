package ar.edu.utn.frc.tup.lciii.entities;

import ar.edu.utn.frc.tup.lciii.models.rps.ShapeHand;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name= "plays_rps")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PlayRpsEntity {
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name= "match_rps_id")
    private MatchRpsEntity matchRps; // ver si no es matchRpsId

    @Enumerated(EnumType.STRING)
    private ShapeHand shapeHandPlayer1;

    @Enumerated(EnumType.STRING)
    private ShapeHand shapeHandPlayer2;

    @ManyToOne
    @JoinColumn(name="winner_id")
    private PlayerEntity winner;
// ROCK, PAPER, SCISSORS
    /*INSERT INTO plays_rps (id, match_rps,shape_hand_player1,shape_hand_player2 , winner_id )
    VALUES (1000000, 1000000 ,'ROCK', 'PAPER', 2, 1111)*/
    /*INSERT INTO plays_rps (id, match_rps_id,shape_hand_player1,shape_hand_player2 , winner_id )
     VALUES (1000000, 1000000 ,'ROCK', 'PAPER', 2, 1111*/
}
