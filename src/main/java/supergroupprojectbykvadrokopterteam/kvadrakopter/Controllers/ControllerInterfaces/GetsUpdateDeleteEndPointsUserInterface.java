package supergroupprojectbykvadrokopterteam.kvadrakopter.Controllers.ControllerInterfaces;

import org.springframework.http.ResponseEntity;
import supergroupprojectbykvadrokopterteam.kvadrakopter.Entityes.UserEntity;

import java.util.List;

public interface GetsUpdateDeleteEndPointsUserInterface {
    ResponseEntity<UserEntity> getUserById(long id);

    ResponseEntity<List<UserEntity>> getAllUsers();

    ResponseEntity<UserEntity> updateUserById(long id);

    ResponseEntity<UserEntity> deleteUserBuId(long id);
}
