package ar.edu.utn.frc.tup.lciii.models;


import ar.edu.utn.frc.tup.lciii.utils.validations.password.ValidPassword;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Player {

    @Schema(title="Player ID", description= "The player id", example= "1")
    private Long id;

    @Schema(title="Player user name", description= "The Player user name", example= "myusername", nullable=false)
    @NotNull(message= "userName cant´t be null")
    private String userName;

    @Schema(title="Player password", description= "The password Player´s ", example= "Cordoba+1", nullable=false)
    @NotNull(message= "password cant´t be null")
    @ValidPassword
    private  String password;

    @Schema(title="Player emaiñl", description= "The email Player´s", example= "email@email.com", nullable=false)
    @NotNull(message= "email cant´t be null")
    @Email(message= "the e-mail need to be a valid email")
    private  String email;

    @Schema(title="Player avatar", description= "The avatar Player´s", example= "example:la url de la imagen...", nullable=true)
    private String avatar;

    @Schema(title="Player last login", description= "The las login Player´s", example= "01-1-2020 21:10:50", nullable=true)
    @JsonFormat
            (shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
    private LocalDateTime lastLogin; // lo tiene como lastLoginDate
}
