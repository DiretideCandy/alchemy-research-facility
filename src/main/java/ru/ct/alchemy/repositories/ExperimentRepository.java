package ru.ct.alchemy.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.ct.alchemy.model.experiment.Experiment;

@Repository
public interface ExperimentRepository extends JpaRepository<Experiment, Long> {
}
