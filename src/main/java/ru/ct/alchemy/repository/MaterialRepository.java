package ru.ct.alchemy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.ct.alchemy.model.inventory.Material;

@Repository
public interface MaterialRepository extends JpaRepository<Material, Long> {

}
