package ar.edu.utn.frc.tup.lciii.services;

import ar.edu.utn.frc.tup.lciii.models.Game;
import ar.edu.utn.frc.tup.lciii.models.Match;
import ar.edu.utn.frc.tup.lciii.models.MatchStatus;
import ar.edu.utn.frc.tup.lciii.models.Player;
import ar.edu.utn.frc.tup.lciii.models.rps.MatchRps;
import ar.edu.utn.frc.tup.lciii.models.rps.PlayRps;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.ArrayList;


public class MatchFactory {

    public static  Match createMatch(Player player, Game game) {
        switch (game.getCode()) {
            case "RPS":
                return  createMatchRps(player, game);
            default:
                return  createMatchRps(player, game);

        }
    }
    public static Class<? extends Match> getTypeOfMatch(String gameCode){
        switch (gameCode) {
            case "RPS":
                return MatchRps.class;
            default:
                return MatchRps.class;

        }
    }

    private static Match createMatchRps(Player player, Game game){
        MatchRps match= (MatchRps) getBasicMatch(player,game);
        match.setNumberOfPlays(10);
        match.setRemainderPlays(10);
        match.setPlayer1Score(0);
        match.setPlayer2Score(0);
        match.setPlays(new ArrayList<PlayRps>());

    return match;
    }
    private static Match getBasicMatch(Player player, Game game){ // ahora tendria que pasar 2 players
        Match match= getMatchInstance(game.getCode());
        match.setPlayer1(player); // este ya no existe, deberia proporcionar player 1 y player 2 aca y  donde sea

        match.setGame(game);
        match.setCreatedDate(LocalDateTime.now());
        match.setStatus(MatchStatus.STARTED);
        return match;
    }

    private static Match getMatchInstance(String gameCode){
    switch(gameCode){
        case "RPS":
            return new MatchRps();
        default:
            return new MatchRps();
    }

    }



}
