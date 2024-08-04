package ru.ct.alchemy.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.ct.alchemy.model.Action;
import ru.ct.alchemy.model.inventory.EquipmentType;

import java.util.List;

@Repository
public interface ActionRepository extends JpaRepository<Action, Long> {
    List<Action> findActionByEquipmentType(EquipmentType equipmentType);
}
