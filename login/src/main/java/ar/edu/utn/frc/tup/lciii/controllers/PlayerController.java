package ar.edu.utn.frc.tup.lciii.controllers;

import ar.edu.utn.frc.tup.lciii.dtos.common.ErrorApi;
import ar.edu.utn.frc.tup.lciii.models.Match;
import ar.edu.utn.frc.tup.lciii.models.Player;
import ar.edu.utn.frc.tup.lciii.services.MatchService;
import ar.edu.utn.frc.tup.lciii.services.PlayerService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/players")
public class PlayerController {

        @Autowired
        private PlayerService playerService;
        @Autowired
        private MatchService matchService;


    @Operation(
            summary="Get a Player by id",
            description= "Return a player by the id. If the player doesn´t exist return 404")
    @ApiResponses( value= {
            @ApiResponse( responseCode="200",description= "Successful operation",content =
            @Content(schema= @Schema(implementation= String.class))),
            @ApiResponse( responseCode="404",description= "Not Found",content =
            @Content(schema= @Schema(implementation= ErrorApi.class))),
            @ApiResponse( responseCode="500",description= "Internal Server Error",content =
            @Content(schema= @Schema(implementation= ErrorApi.class)))
    })

    @GetMapping("/{id}")
    public ResponseEntity<Player> getById(@PathVariable Long id) {
        Player player= playerService.getPlayerById(id); // llamo al servicio que se va a entregar el player listo para mostrar (despues de haberlo mapeado con los datos de playerEntity en Player
        return ResponseEntity.ok(player); //
    }

    @Operation(
            summary="Create a new Player",
            description= "Return a player created with your id. If a player exist with the userName or email, then return 404." +
                    "Additionally, the mail must be valid and the password must have at least 8 characters and contains at least one number, " +
                    "one lowecase letter, one uppercas leter and one special character.")
    @ApiResponses( value= {
            @ApiResponse( responseCode="200",description= "Successful operation",content =
            @Content(schema= @Schema(implementation= String.class))),
            @ApiResponse( responseCode="400",description= "UserName or email already exists",content =
            @Content(schema= @Schema(implementation= ErrorApi.class))),
            @ApiResponse( responseCode="500",description= "Internal Server Error",content =
            @Content(schema= @Schema(implementation= ErrorApi.class)))
    })



    @PostMapping("/")
    public ResponseEntity<Player> savePlayer(@RequestBody @Valid  Player player) {
        Player playerSaved = playerService.savePlayer(player);
        if (Objects.isNull(playerSaved)) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Username or email already exists");
        } else {
            return ResponseEntity.ok(playerSaved);
        }
    }
        @GetMapping("/{id}/matches")
        public ResponseEntity<List<Match>> getMatchesOfPlayer( @PathVariable Long id)
        {
            List<Match> matches= matchService.getMatchesByPlayer(id);
            return ResponseEntity.ok(matches);
        }



}
