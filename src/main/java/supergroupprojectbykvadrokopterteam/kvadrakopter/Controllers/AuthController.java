package supergroupprojectbykvadrokopterteam.kvadrakopter.Controllers;

import org.springframework.http.ResponseEntity;
import supergroupprojectbykvadrokopterteam.kvadrakopter.Entityes.UserEntity;

public interface AuthController {
    ResponseEntity<UserEntity> registrationEndPoint(UserEntity user);

    ResponseEntity<UserEntity> authEndPoint(UserEntity user);

    ResponseEntity<UserEntity> vkAuthEndPoint(UserEntity user);
}
