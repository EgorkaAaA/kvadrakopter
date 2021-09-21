package supergroupprojectbykvadrokopterteam.kvadrakopter.Services.ServiceInterFaces;

import org.springframework.http.ResponseEntity;
import supergroupprojectbykvadrokopterteam.kvadrakopter.Entityes.UserEntity;

public interface UserServiceInterface {
    ResponseEntity<UserEntity> saveUserInDataBase(UserEntity user);

    UserEntity findUserByUserName(String userName);

    UserEntity createUserFromVkAuth(String userName);
}
