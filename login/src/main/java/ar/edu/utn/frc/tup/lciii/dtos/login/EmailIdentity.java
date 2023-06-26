package ar.edu.utn.frc.tup.lciii.dtos.login;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmailIdentity extends Identity{
    @Schema(title= "Email to legged in",
            description="The player email",
            example="email@email.com",
            nullable = false)
    @NotNull(message="email can´t be null")
    @JsonProperty("email")
    private String email;
}
