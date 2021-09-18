package supergroupprojectbykvadrokopterteam.kvadrakopter.Entityes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RolesEntity {
    @Id
    private String roleName;
}
