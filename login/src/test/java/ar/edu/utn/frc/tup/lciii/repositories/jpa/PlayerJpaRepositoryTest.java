package ar.edu.utn.frc.tup.lciii.repositories.jpa;

import ar.edu.utn.frc.tup.lciii.entities.PlayerEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;


@DataJpaTest
public class PlayerJpaRepositoryTest {
    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private PlayerJpaRepository playerJpaRepository;

    @Test
    public void findByUserNameOrEmailTest(){ // no puedo usar los valores de daniel porque ya los tengo cargadps en la base
        PlayerEntity playerEntity= new PlayerEntity();

        playerEntity.setEmail("email@email.com");
        playerEntity.setUserName("Paloma");
        playerEntity.setPassword("Password03#");

        entityManager.persist(playerEntity);
        entityManager.flush();

        Optional<PlayerEntity> result= playerJpaRepository.findByUserNameOrEmail("Paloma","email@email.com");
        assertEquals("Paloma", result.get().getUserName());
    }
}
