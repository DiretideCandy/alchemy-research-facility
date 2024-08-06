package ru.ct.alchemy.presentation.schedulers;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import ru.ct.alchemy.model.Report;
import ru.ct.alchemy.model.experiment.Experiment;
import ru.ct.alchemy.model.experiment.ExperimentStatus;
import ru.ct.alchemy.model.inventory.Material;
import ru.ct.alchemy.repositories.ExperimentRepository;
import ru.ct.alchemy.repositories.ReportRepository;

import java.util.List;

@Slf4j
@Component
@AllArgsConstructor
public class CreateReportsScheduler {

    private final ExperimentRepository experimentRepository;
    private final ReportRepository reportRepository;
    private final ResourceLoaderFileRepository resourceLoaderFileRepository;

    @Scheduled(cron = "*/20 * * * * *")
    @Transactional
    public void createReport() {

        experimentRepository.findByStatus(ExperimentStatus.FINISHED)
                .forEach(exp -> {
                    Report report = resourceLoaderFileRepository.readRandomFile("reports/reports-1-"+exp.getMaterials().size());
                    report.setExperiment(exp);
                    pasteExperimentData(report, exp);
                    reportRepository.save(report);

                    exp.setReport(report);
                    exp.setStatus(ExperimentStatus.REPORTED);
                    experimentRepository.save(exp);
                });
    }

    private void pasteExperimentData(Report report, Experiment experiment) {
        report.setText(report.getText()
                .replace("[Оборудование]", "["+experiment.getEquipment().getName()+"]"));

        List<String> materialNames = experiment.getMaterials()
                        .stream()
                        .map(Material::getName)
                        .toList();

        for (int i = 0; i < materialNames.size(); i++) {
            report.setText(report.getText()
                    .replace("[Материал "+(i+1)+"]", "["+materialNames.get(i)+"]"));
        }
    }

}
