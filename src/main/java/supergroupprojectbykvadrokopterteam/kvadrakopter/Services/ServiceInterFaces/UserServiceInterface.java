package supergroupprojectbykvadrokopterteam.kvadrakopter.Services.ServiceInterFaces;

import org.springframework.http.ResponseEntity;
import supergroupprojectbykvadrokopterteam.kvadrakopter.Entityes.UserEntity;
import supergroupprojectbykvadrokopterteam.kvadrakopter.Exceptions.UserAllReadyExistsException;
import supergroupprojectbykvadrokopterteam.kvadrakopter.Exceptions.UserNotFoundException;

public interface UserServiceInterface {
    ResponseEntity<UserEntity> saveUserInDataBase(UserEntity user) throws UserAllReadyExistsException;

    UserEntity findUserByUserName(String userName) throws UserNotFoundException;

    UserEntity createUserFromVkAuth(String userName);
}
