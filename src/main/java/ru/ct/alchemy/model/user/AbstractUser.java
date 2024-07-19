package ru.ct.alchemy.model.user;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "user_type", discriminatorType = DiscriminatorType.STRING)
@Table(name = "users", schema = "research")
@Getter
@Setter
public abstract class AbstractUser implements User {

    @Id
    private Long id;

    private String username;
}
