package ru.ct.alchemy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.ct.alchemy.model.experiment.ExperimentStatusWorkflow;

@Repository
public interface ExperimentStatusWorkflowRepository extends JpaRepository<ExperimentStatusWorkflow, Long> {
}
