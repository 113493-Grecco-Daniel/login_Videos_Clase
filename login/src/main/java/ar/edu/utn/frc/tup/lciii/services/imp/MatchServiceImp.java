package ar.edu.utn.frc.tup.lciii.services.imp;

import ar.edu.utn.frc.tup.lciii.dtos.match.MatchDTO;
import ar.edu.utn.frc.tup.lciii.dtos.play.PlayRequest;
import ar.edu.utn.frc.tup.lciii.entities.MatchEntity;
import ar.edu.utn.frc.tup.lciii.models.*;
import ar.edu.utn.frc.tup.lciii.repositories.jpa.MatchEntityFactory;
import ar.edu.utn.frc.tup.lciii.repositories.jpa.MatchJpaRepository;
import ar.edu.utn.frc.tup.lciii.services.GameService;
import ar.edu.utn.frc.tup.lciii.services.MatchService;
import ar.edu.utn.frc.tup.lciii.services.PlayerService;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.hibernate.Hibernate;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import ar.edu.utn.frc.tup.lciii.services.MatchFactory;
import ar.edu.utn.frc.tup.lciii.services.PlayFactory;
import ar.edu.utn.frc.tup.lciii.services.PlayStrategyFactory;
import ar.edu.utn.frc.tup.lciii.services.PlayMatch;
import org.springframework.web.server.ResponseStatusException;

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

    @Autowired
    private PlayStrategyFactory playStrategyFactory;// segun yo

    @Override
    public List<Match> getMatchesByPlayer(Long PlayerId) {
        List<Match> matches = new ArrayList<>();
        Optional<List<MatchEntity>> optionalMatchEntities = matchJpaRepository.getAllByPlayerId(PlayerId);
        if (optionalMatchEntities.isPresent()) {
        optionalMatchEntities.get().forEach(
                me ->{ matches.add(modelMapper.map(me, MatchFactory.getTypeOfMatch(me.getGame().getCode())));}
                );
        }
        return matches;
    }

    @Override
    public Match createMatch(MatchDTO matchDTO) {

       Player player= playerService.getPlayerById(matchDTO.getPlayerId());
       Game game= gameService.getGame(matchDTO.getGameId());
       Match match= MatchFactory.createMatch(player, game);

       MatchEntity matchEntity = matchJpaRepository.save(modelMapper.map(match, MatchEntityFactory.getTypeOfMatch(match)));

        return modelMapper.map(matchEntity, match.getClass());

    }

    @Override
    public Match getMatchById(Long id) {

        // MatchEntity me= matchJpaRepository.getReferenceById(id); // este era el metodo que traia problemas
     // MatchEntity me= matchJpaRepository.getMatchById(id);//solucion al problema
     //INFO: https://www.baeldung.com/hibernate-proxy-to-real-entity-object
       MatchEntity me= (MatchEntity)  Hibernate.unproxy(matchJpaRepository.getReferenceById(id)); // despues de hibernet 5.2 se permite utilizar unproxy
        if(me!=null){
         Match match = modelMapper.map(me, MatchFactory.getTypeOfMatch(me.getGame().getCode()));
         return match;
     }else{
         throw new EntityNotFoundException();
     }
    }

    @Transactional
    @Override
    public Play play(Long matchId, PlayRequest playRequest) {

        Match match= this.getMatchById(matchId);
        if(match==null){
            throw new EntityNotFoundException();
        }
        if(match.getStatus() != MatchStatus.STARTED)
        {
            throw new ResponseStatusException(HttpStatus.CONFLICT, String.format("The match is %s", match.getStatus()));
        }

        Play play= PlayFactory.getPlayInstance(playRequest, match.getGame().getCode());
        PlayMatch playMatch= playStrategyFactory.getPlayStrategy(match.getGame().getCode());
        return playMatch.play(play, match);



    }
}