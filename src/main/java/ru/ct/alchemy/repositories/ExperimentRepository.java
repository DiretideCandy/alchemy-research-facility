package ru.ct.alchemy.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.ct.alchemy.model.experiment.Experiment;
import ru.ct.alchemy.model.experiment.ExperimentStatus;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Repository
public interface ExperimentRepository extends JpaRepository<Experiment, Long> {
    Optional<Experiment> findByIdAndStatus(Long id, ExperimentStatus experimentStatus);
    List<Experiment> findByStatus(ExperimentStatus status);

    List<Experiment> findByCreatedAtBetween(Date from, Date to);
    List<Experiment> findByCreatedAtBefore(Date to);
    List<Experiment> findByCreatedAtAfter(Date from);
}
