package ar.edu.utn.frc.tup.lciii.entities;

import ar.edu.utn.frc.tup.lciii.models.MatchStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name="matches")
@Inheritance( strategy= InheritanceType.JOINED)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MatchEntity {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @JoinColumn(name="game_id")
    @ManyToOne
    private GameEntity game;

    @JoinColumn(name="player1_id") //modifique player 1 y 2 por cambios en la base - video 33
    @ManyToOne
    private PlayerEntity player1;

    @JoinColumn(name="player2_id")
    @ManyToOne
    private PlayerEntity player2;

    @Column
    private LocalDateTime createdAt;

    @Column
    private LocalDateTime updatedAt;

    @Column
    @Enumerated(EnumType.STRING)
    private MatchStatus status;

}
