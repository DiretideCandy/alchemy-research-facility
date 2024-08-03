package ru.ct.alchemy.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.ct.alchemy.model.Action;

@Repository
public interface ActionRepository extends JpaRepository<Action, Long> {
}
