package ar.edu.utn.frc.tup.lciii.services.imp;

import ar.edu.utn.frc.tup.lciii.dtos.login.Credential;
import ar.edu.utn.frc.tup.lciii.dtos.login.CredentialV2;
import ar.edu.utn.frc.tup.lciii.dtos.login.EmailIdentity;
import ar.edu.utn.frc.tup.lciii.dtos.login.UserNameIdentity;
import ar.edu.utn.frc.tup.lciii.models.Player;
import ar.edu.utn.frc.tup.lciii.services.LoginService;
import ar.edu.utn.frc.tup.lciii.services.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;


@Service
public class LoginServiceImp implements LoginService {

    @Autowired
    private PlayerService playerService;  // esta bien este y no el loginService??
                //respuest: SI!! esta bien,  para no cruzar las capas de dominio si esta bien que use el player service
    @Override
    public Player login(Credential credential) {
        Player player;
        if(credential.getIdentity() instanceof UserNameIdentity){
            player=loginWithIdentity((UserNameIdentity) credential.getIdentity(), credential.getPassword());
        }else{
            player=loginWithIdentity((EmailIdentity) credential.getIdentity(), credential.getPassword());
        }
        return updateLastLogin(player);
    }
    @Override
    public Player login(CredentialV2 credential) {
      Player player= playerService.getPlayerByUserNameOrEmailAndPassword(credential.getIdentity(), credential.getPassword());
        return updateLastLogin(player);
    }
    private Player loginWithIdentity(UserNameIdentity usernameIdentity, String password) {
        Player player=playerService.getPlayerByUserNameAndPassword(usernameIdentity.getUserName(), password);
        return updateLastLogin(player);
    }
    private Player loginWithIdentity(EmailIdentity emailIdentity, String password) {
        Player player=playerService.getPlayerByEmailAndPassword(emailIdentity.getEmail(), password);
        return updateLastLogin(player);
    }

    private Player updateLastLogin(Player player){
        player.setLastLogin(LocalDateTime.now()); // en mi entiti y player se llama solo lastLogin no LastLoginDate, ver que libreria usa para localdatetime.now
        return playerService.savePlayer(player); // tambien actualice el login 1 que en los videos no.. ver
    }



}
