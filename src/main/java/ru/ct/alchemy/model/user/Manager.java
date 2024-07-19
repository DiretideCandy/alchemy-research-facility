package ru.ct.alchemy.model.user;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("Manager")
public class Manager extends AbstractUser{

}
