package ar.edu.utn.frc.tup.lciii.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name="matches_rps") // HHH000139: Illegal use of @Table in a subclass of a SINGLE_TABLE hierarchy: ar.edu.utn.frc.tup.lciii.entities.MatchRpsEntity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MatchRpsEntity extends MatchEntity{
    private Long id; //Column 'id' is duplicated in mapping for entity 'ar.edu.utn.frc.tup.lciii.entities.MatchRpsEntity' (use '@Column(insertable=false, updatable=false)' when mapping multiple properties to the same column)
    private Integer numberOfPlays;

    private Integer remainderPlays;

    private Integer player1Score;

    private Integer player2Score;

    @OneToMany(mappedBy= "matchRps")
    private List<PlayRpsEntity> plays;

    @OneToOne
    @JoinColumn( name="winner_id")
    private PlayerEntity winner;


}
