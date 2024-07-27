package ru.ct.alchemy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.ct.alchemy.model.experiment.ExperimentStatus;

@Repository
public interface ExperimentStatusRepository extends JpaRepository<ExperimentStatus, Long> {
}
