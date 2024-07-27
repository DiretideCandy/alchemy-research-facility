package ru.ct.alchemy.model.experiment;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "experiment_status_workflow", schema = "research", uniqueConstraints = {
        @UniqueConstraint(columnNames = {
                "from_id", "to_id"
        })
})
@Getter
@Setter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ExperimentStatusWorkflow {

    @EmbeddedId
    private ExperimentWorkflowPK id;

    @Column(name = "comment")
    private String comment;
}
