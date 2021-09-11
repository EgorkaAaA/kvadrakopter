package supergroupprojectbykvadrokopterteam.kvadrakopter.Entityes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public abstract class EntitySettings {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long id;
}

