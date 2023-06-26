package ar.edu.utn.frc.tup.lciii.services;

import ar.edu.utn.frc.tup.lciii.dtos.match.MatchDTO;
import ar.edu.utn.frc.tup.lciii.models.Match;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface MatchService {
    List<Match> getMatchesByPlayer(Long PlayerId);
    Match createMatch(MatchDTO matchDTO);
}