package ar.edu.utn.frc.tup.lciii;

import ar.edu.utn.frc.tup.lciii.controllers.ControllerExceptionHandler;
import ar.edu.utn.frc.tup.lciii.controllers.PingController;
import ar.edu.utn.frc.tup.lciii.controllers.PlayerController;
import ar.edu.utn.frc.tup.lciii.services.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;


@SpringBootTest
public class SmokeTest {

    @Autowired
    private PlayerController playerController;
    @Autowired
    private PingController pingController;
    @Autowired
    private ControllerExceptionHandler controllerExceptionHandler;
    @Autowired
    private PlayerService playerService;


    @Test
    public void contextLoads() throws Exception {
        assertThat(playerController).isNotNull();
        assertThat(pingController).isNotNull();
        assertThat(controllerExceptionHandler).isNotNull();
        assertThat(playerService).isNotNull();
    }


}
