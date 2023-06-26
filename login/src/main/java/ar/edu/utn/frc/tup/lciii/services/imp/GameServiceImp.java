package ar.edu.utn.frc.tup.lciii.services.imp;


import ar.edu.utn.frc.tup.lciii.entities.GameEntity;
import ar.edu.utn.frc.tup.lciii.models.Game;
import ar.edu.utn.frc.tup.lciii.repositories.jpa.GameJpaRepository;
import ar.edu.utn.frc.tup.lciii.services.GameService;
import jakarta.persistence.EntityNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class GameServiceImp  implements GameService {

    @Autowired
    private GameJpaRepository gameJpaRepository;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public Game getGame(Long gameId) {
        GameEntity gameEntity = gameJpaRepository.getReferenceById(gameId);

        if(Objects.isNull(gameEntity.getDescription())){
            throw new EntityNotFoundException();
        }
        else{
            Game game = modelMapper.map(gameEntity, Game.class);
            return game;
        }


    }
}
