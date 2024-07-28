package ru.ct.alchemy.model.experiment;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Embeddable
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ExperimentWorkflowPK implements Serializable {

    @Column(name = "from_id", nullable = false)
    @Enumerated(EnumType.STRING)
    private ExperimentStatus from;

    @Column(name = "to_id", nullable = false)
    @Enumerated(EnumType.STRING)
    private ExperimentStatus to;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ExperimentWorkflowPK pk = (ExperimentWorkflowPK) o;
        if (this.getFrom().equals(pk.getFrom())) return false;
        return this.getTo().equals(pk.getTo());
    }

    @Override
    public int hashCode() {
        return 1_000 * from.hashCode() + to.hashCode();
    }
}
