package ar.edu.utn.frc.tup.lciii.repositories.jpa;

import ar.edu.utn.frc.tup.lciii.entities.MatchEntity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface MatchJpaRepository  extends JpaRepository<MatchEntity, Long> {
 //   @Query("SELECT m FROM MatchEntity  m Where m.player.id = :playerId")
    Optional<List<MatchEntity>> getAllByPlayerId(Long playerId);

    MatchEntity getMatchById(Long id); // lo creo para saltear que en vez de usar el hibernet proxy devuelva el objeto real
}
