package supergroupprojectbykvadrokopterteam.kvadrakopter.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import supergroupprojectbykvadrokopterteam.kvadrakopter.Entityes.RolesEntity;
import supergroupprojectbykvadrokopterteam.kvadrakopter.Entityes.UserEntity;
import supergroupprojectbykvadrokopterteam.kvadrakopter.Exceptions.UserAllReadyExistsException;
import supergroupprojectbykvadrokopterteam.kvadrakopter.Exceptions.UserNotFoundException;
import supergroupprojectbykvadrokopterteam.kvadrakopter.Repositories.UserRepo;
import supergroupprojectbykvadrokopterteam.kvadrakopter.Services.ServiceInterFaces.UserServiceInterface;

import javax.transaction.Transactional;
import java.util.Collection;
import java.util.stream.Collectors;

@Service
public class UserService implements UserDetailsService, UserServiceInterface {
    private final UserRepo userRepo;

    @Autowired
    public UserService(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        UserEntity user = userRepo.findByUserName(userName);
        if(user == null) {
            throw new UsernameNotFoundException(String.format("User with name %s not found", userName));
        }
        return new User(user.getUserName(), user.getPassword(),mapRolesToGrantedAuthority(user.getRoles()));
    }

    private Collection<? extends GrantedAuthority> mapRolesToGrantedAuthority(Collection<RolesEntity> roles) {
        return roles.stream().map(r -> new SimpleGrantedAuthority(r.getRoleName())).collect(Collectors.toList());
    }

    @Override
    public ResponseEntity<UserEntity> saveUserInDataBase(UserEntity user) throws UserAllReadyExistsException {
        UserEntity userFromDb = userRepo.findByUserName(user.getUserName());
        if(userFromDb != null) {
            throw new UserAllReadyExistsException(String.format("User with name %s all ready exists", user.getUserName()));
        }
        user.setPassword(passwordEncoder().encode(user.getPassword()));
        userRepo.save(user);
        return new ResponseEntity<>(user, HttpStatus.CREATED);
    }

    @Override
    public UserEntity findUserByUserName(String userName) throws UserNotFoundException {
        UserEntity userFromDb = userRepo.findByUserName(userName);
        if(userFromDb == null) {
            throw new UserNotFoundException(String.format("User with name %s not found",userName));
        }
        return userFromDb;
    }

    @Override
    public UserEntity createUserFromVkAuth(String userName) {
        return null;
    }

    private PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
