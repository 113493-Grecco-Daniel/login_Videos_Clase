package ar.edu.utn.frc.tup.lciii.services.imp;

import ar.edu.utn.frc.tup.lciii.dtos.match.MatchDTO;
import ar.edu.utn.frc.tup.lciii.entities.MatchEntity;
import ar.edu.utn.frc.tup.lciii.models.Game;
import ar.edu.utn.frc.tup.lciii.models.Match;
import ar.edu.utn.frc.tup.lciii.models.MatchStatus;
import ar.edu.utn.frc.tup.lciii.models.Player;
import ar.edu.utn.frc.tup.lciii.repositories.jpa.MatchJpaRepository;
import ar.edu.utn.frc.tup.lciii.services.GameService;
import ar.edu.utn.frc.tup.lciii.services.MatchService;
import ar.edu.utn.frc.tup.lciii.services.PlayerService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ar.edu.utn.frc.tup.lciii.services.MatchFactory;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class MatchServiceImp implements MatchService {

    @Autowired
    private MatchJpaRepository matchJpaRepository;

    @Autowired
    private PlayerService playerService;

    @Autowired
    private GameService gameService;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<Match> getMatchesByPlayer(Long PlayerId) {
        List<Match> matches = new ArrayList<>();
        Optional<List<MatchEntity>> optionalMatchEntities = matchJpaRepository.getAllByPlayerId(PlayerId);
        if (optionalMatchEntities.isPresent()) {
        optionalMatchEntities.get().forEach(
                me ->{ matches.add(modelMapper.map(me, MatchFactory.createMatch(me.getGame().getCode()).getClass())); }
                // hacemos to-do esto de " MatchFactory.createMatch(me.getGame().getCode())".get class para que nos figa la clase del objeto al que hay que mapear
                );
        }
        return matches;
    }

    @Override
    public Match createMatch(MatchDTO matchDTO) {

       Player player= playerService.getPlayerById(matchDTO.getPlayerId());
       Game game= gameService.getGame(matchDTO.getGameId());
        Match match= MatchFactory.createMatch(game.getCode());
        match.setPlayer(player);
        match.setGame(game);
        match.setCreatedDate(LocalDateTime.now());
        match.setStatus(MatchStatus.STARTED);
        MatchEntity matchEntity = matchJpaRepository.save(modelMapper.map(match, MatchEntity.class));

        return modelMapper.map(matchEntity, match.getClass());

    }
}