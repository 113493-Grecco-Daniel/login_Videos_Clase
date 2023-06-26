package ar.edu.utn.frc.tup.lciii.controllers;


import ar.edu.utn.frc.tup.lciii.dtos.match.MatchDTO;
import ar.edu.utn.frc.tup.lciii.models.Match;
import ar.edu.utn.frc.tup.lciii.models.Player;
import ar.edu.utn.frc.tup.lciii.services.MatchService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.Objects;

@RestController
@RequestMapping(value = "/matches")
public class MatchController {

    @Autowired
    private MatchService matchService;


    @PostMapping("/")
    public ResponseEntity<Match> saveMatch(@RequestBody @Valid MatchDTO matchDTO) {
        Match matchSaved = matchService.createMatch(matchDTO);
        if (Objects.isNull(matchSaved)) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "The request has an error");
        } else {
            return ResponseEntity.ok(matchSaved);
        }
    }
}


