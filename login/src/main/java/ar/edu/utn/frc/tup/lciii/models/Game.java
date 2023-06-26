package ar.edu.utn.frc.tup.lciii.models;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Game {
    private Long id;
    private  String code;
    private  String userName; // ver porque lo tiene como name
    private   String description;
    private  String rules;
}
