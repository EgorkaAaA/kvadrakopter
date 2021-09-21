package supergroupprojectbykvadrokopterteam.kvadrakopter.Controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import supergroupprojectbykvadrokopterteam.kvadrakopter.Controllers.ControllerInterfaces.AuthController;
import supergroupprojectbykvadrokopterteam.kvadrakopter.Entityes.UserEntity;

@RestController
@RequestMapping("/api/auth")
public class AuthControllerImpl implements AuthController {
    @Override
    @PostMapping("/post/registration")
    public ResponseEntity<UserEntity> registrationEndPoint(UserEntity user) {

        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @Override
    @GetMapping("/get/auth-user")
    public ResponseEntity<UserEntity> authEndPoint(UserEntity user) {
        return null;
    }

    @Override
    @PostMapping("/post/vk-auth")
    public ResponseEntity<UserEntity> vkAuthEndPoint(UserEntity user) {
        return null;
    }
}
