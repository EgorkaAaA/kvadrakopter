package supergroupprojectbykvadrokopterteam.kvadrakopter.Services.ServiceInterFaces;

import org.springframework.http.ResponseEntity;
import supergroupprojectbykvadrokopterteam.kvadrakopter.Entityes.UserEntity;
import supergroupprojectbykvadrokopterteam.kvadrakopter.Exceptions.UserAllReadyExistsException;

public interface UserServiceInterface {
    ResponseEntity<UserEntity> saveUserInDataBase(UserEntity user) throws UserAllReadyExistsException;

    UserEntity findUserByUserName(String userName);

    UserEntity createUserFromVkAuth(String userName);
}
