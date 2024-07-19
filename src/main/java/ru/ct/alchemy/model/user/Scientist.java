package ru.ct.alchemy.model.user;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("Scientist")
public class Scientist extends AbstractUser {

}
