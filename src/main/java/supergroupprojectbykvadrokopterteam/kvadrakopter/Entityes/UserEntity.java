package supergroupprojectbykvadrokopterteam.kvadrakopter.Entityes;

import javax.persistence.OneToMany;
import java.util.Collection;


public class UserEntity extends EntitySettings {
    private String userName;

    private String password;

    @OneToMany
    private Collection<Roles> roles;
}
