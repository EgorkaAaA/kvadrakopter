package supergroupprojectbykvadrokopterteam.kvadrakopter.Controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import supergroupprojectbykvadrokopterteam.kvadrakopter.Controllers.ControllerInterfaces.AuthController;
import supergroupprojectbykvadrokopterteam.kvadrakopter.Entityes.UserEntity;
import supergroupprojectbykvadrokopterteam.kvadrakopter.Exceptions.UserAllReadyExistsException;
import supergroupprojectbykvadrokopterteam.kvadrakopter.KvadrakopterApplication;
import supergroupprojectbykvadrokopterteam.kvadrakopter.Services.UserService;

@RestController
@RequestMapping("/api/auth")
public class AuthControllerImpl implements AuthController {
    private final UserService userService;
    private final Logger logger = LoggerFactory.getLogger(KvadrakopterApplication.class);

    @Autowired
    public AuthControllerImpl(UserService userService) {
        this.userService = userService;
    }

    @Override
    @PostMapping("/post/registration")
    public ResponseEntity<UserEntity> registrationEndPoint(UserEntity user) {
        try {
            userService.saveUserInDataBase(user);
            logger.info("User created");
        } catch (UserAllReadyExistsException e) {
            logger.error(e.getMessage());
        }
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
