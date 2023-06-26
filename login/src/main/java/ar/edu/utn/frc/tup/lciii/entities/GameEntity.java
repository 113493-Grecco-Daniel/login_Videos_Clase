package ar.edu.utn.frc.tup.lciii.entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name="games")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class GameEntity {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @Column
    private String code;

    @Column
    private String userName;

    @Lob
    @Column
    private String description;

    @Lob
    @Column
    private String rules;
}
