package supergroupprojectbykvadrokopterteam.kvadrakopter.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import supergroupprojectbykvadrokopterteam.kvadrakopter.Entityes.UserEntity;

public interface UserRepo extends JpaRepository<UserEntity, Long> {
    UserEntity findByUserName(String userName);
}
