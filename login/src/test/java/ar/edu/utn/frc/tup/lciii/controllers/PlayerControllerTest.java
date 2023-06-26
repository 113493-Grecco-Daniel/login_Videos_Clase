package ar.edu.utn.frc.tup.lciii.controllers;

import ar.edu.utn.frc.tup.lciii.models.Player;
import ar.edu.utn.frc.tup.lciii.services.PlayerService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;



import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@WebMvcTest(PlayerController.class)
public class PlayerControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private PlayerService service;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void getByidTest() throws Exception {

        Player player=new Player();
        player.setId(1L);
        player.setUserName("Jose");
        player.setEmail("jones@gmail.com");
        player.setPassword("Cordoba+25");
        player.setAvatar("un gato");

        when(service. getPlayerById(1L)).thenReturn(player);
        this.mockMvc.perform(get("/players/1")).andDo(print()).andExpect(status().isOk())
                .andExpect(jsonPath("$.userName").value("Jose"))
                .andExpect(jsonPath("$.email").value("jones@gmail.com"))
                .andExpect(jsonPath("$.password").value("Cordoba+25"))
                ;
        /// esa es una opcion, ahora abajo hacemos otra opcion de  pedir toodo el resultado y meterlo en un string como
        // un json, despues pedimos el username del json result y lo comparamos ( son 2 formas de verificar lo mismo)
        MvcResult mvcResult = this.mockMvc.perform(get("/players/1")).andDo(print()).andExpect(status().isOk())
                .andReturn();
        Player result= objectMapper.readValue(mvcResult.getResponse().getContentAsString(), Player.class);

        Assertions.assertEquals("Jose", result.getUserName());


    }


}
