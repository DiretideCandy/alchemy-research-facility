package ru.ct.alchemy.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.ct.alchemy.model.inventory.Equipment;

@Repository
public interface EquipmentRepository extends JpaRepository<Equipment, Long> {

}
