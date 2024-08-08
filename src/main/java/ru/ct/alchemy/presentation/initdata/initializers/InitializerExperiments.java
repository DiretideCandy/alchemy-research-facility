package ru.ct.alchemy.presentation.initdata.initializers;

import lombok.AllArgsConstructor;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import ru.ct.alchemy.model.Action;
import ru.ct.alchemy.model.experiment.Experiment;
import ru.ct.alchemy.model.experiment.ExperimentStatus;
import ru.ct.alchemy.model.inventory.Equipment;
import ru.ct.alchemy.model.inventory.Material;
import ru.ct.alchemy.presentation.initdata.Initializer;
import ru.ct.alchemy.repositories.ActionRepository;
import ru.ct.alchemy.repositories.EquipmentRepository;
import ru.ct.alchemy.repositories.ExperimentRepository;
import ru.ct.alchemy.repositories.MaterialRepository;

import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

@Component
@AllArgsConstructor
@Order(6)
public class InitializerExperiments implements Initializer {
    private final ExperimentRepository experimentRepository;
    private final EquipmentRepository equipmentRepository;
    private final MaterialRepository materialRepository;
    private final ActionRepository actionRepository;

    private static final List<String> peopleAdjectives = List.of(
            "Гениальный", "Забавный", "Трудолюбивый", "Эксцентричный", "Внимательный",
            "Креативный","Оптимистичный", "Скептический", "Талантливый", "Увлечённый"
    );

    private static final List<String> peopleNouns = List.of(
            "ученый", "исследователь", "биолог", "аналитик", "изобретатель",
            "технолог", "математик", "физик", "химик"
    );

    private static final Random rnd = new Random();

    @Override
    @Transactional
    public void create(){

        List<Equipment> equipmentList = equipmentRepository.findAll();
        List<Material> materialsList = materialRepository.findAll();

        createExperiment(365L, ExperimentStatus.FILLED_IN, equipmentList, materialsList);
        createExperiment(365L, ExperimentStatus.FILLED_IN, equipmentList, materialsList);

        createExperiment(365L, ExperimentStatus.APPROVED, equipmentList, materialsList);
        createExperiment(365L, ExperimentStatus.APPROVED, equipmentList, materialsList);

        createExperiment(2L, ExperimentStatus.RUNNING, equipmentList, materialsList);
        createExperiment(2L, ExperimentStatus.RUNNING, equipmentList, materialsList);
    }

    private void createExperiment(long maxDaysBefore,
                                  ExperimentStatus experimentStatus,
                                  List<Equipment> equipmentList,
                                  List<Material> materialsList) {

        Equipment equipment = equipmentList.get(rnd.nextInt(equipmentList.size()));
        List<Action> actionList = actionRepository.findActionByEquipmentType(equipment.getType());

        experimentRepository.save(
                Experiment.builder()
                        .createdAt(generateRandomPastDate(TimeUnit.DAYS.toMillis(maxDaysBefore)))
                        .createdBy(generateRandomName())
                        .approvedBy(generateApprovedBy(experimentStatus))
                        .status(experimentStatus)
                        .equipment(equipment)
                        .materials(IntStream.range(0, rnd.nextInt(3) + 1)
                                .mapToObj(i -> materialsList.get(rnd.nextInt(materialsList.size())))
                                .toList())
                        .action(actionList.get(rnd.nextInt(actionList.size())))
                        .build());
    }

    private String generateApprovedBy(ExperimentStatus experimentStatus) {
        return switch(experimentStatus){
            case CREATED, FILLED_IN -> null;
            case APPROVED, REPORTED, RUNNING, CANCELLED, FINISHED -> generateRandomName();
        };
    }

    private String generateRandomName(){
        return peopleAdjectives.get(rnd.nextInt(peopleAdjectives.size()))
                + " " + peopleNouns.get(rnd.nextInt(peopleNouns.size()));
    }

    private Date generateRandomPastDate(long millisAgo){
        long todayMillis = System.currentTimeMillis();

        long oneYearAgoMillis = todayMillis - millisAgo;

        long randomMillis = oneYearAgoMillis + (long) (rnd.nextDouble() * (todayMillis - oneYearAgoMillis));
        return new Date(randomMillis);
    }
}
