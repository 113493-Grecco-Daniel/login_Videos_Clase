package ar.edu.utn.frc.tup.lciii.dtos.login;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CredentialV2 {

      @Schema(title= "Email or UserName to logged in",
      description="The player email or username",
      example="email@email.com",
      nullable = false)

      @NotNull(message="identity cant´t be null")
      @JsonProperty("identity")
      private String identity;
      @NotNull(message="password cant´t be null")
      private String password;
}