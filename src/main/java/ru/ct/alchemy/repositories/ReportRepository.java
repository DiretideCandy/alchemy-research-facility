package ru.ct.alchemy.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.ct.alchemy.model.Report;

@Repository
public interface ReportRepository extends JpaRepository<Report, Long> {

}
