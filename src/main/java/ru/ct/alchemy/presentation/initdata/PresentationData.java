package ru.ct.alchemy.presentation.initdata;

import lombok.Getter;
import org.springframework.stereotype.Component;
import ru.ct.alchemy.model.experiment.ExperimentStatus;
import ru.ct.alchemy.presentation.initdata.tuples.Triple;

import java.util.List;

import static ru.ct.alchemy.model.experiment.ExperimentStatus.*;

@Component
@Getter
public class PresentationData {

    private final List<Triple<ExperimentStatus, ExperimentStatus, String>> workflow = List.of(
            // основной процесс
            new Triple<>(CREATED, FILLED_IN, "Заполнить все поля"),
            new Triple<>(FILLED_IN, APPROVED, "Согласовать проведение эксперимента"),
            new Triple<>(APPROVED, RUNNING, "Начать проводить эксперимент"),
            new Triple<>(RUNNING, FINISHED, "Завершить проведение эксперимента"),
            new Triple<>(FINISHED, REPORTED, "Сформировать отчёт"),
            // отмена из почти любого статуса
            new Triple<>(CREATED, CANCELLED, "Отменить созданный эксперимент"),
            new Triple<>(FILLED_IN, CANCELLED, "Отменить созданный эксперимент"),
            new Triple<>(APPROVED, CANCELLED, "Отменить согласованный эксперимент"),
            new Triple<>(RUNNING, CANCELLED, "Отменить проводящийся эксперимент"),
            new Triple<>(FINISHED, CANCELLED, "Отменить завершённый эксперимент"),
            // переходы на предыдущий статус до начала эксперимента
            new Triple<>(FILLED_IN, CREATED, "Оформить эксперимент заново"),
            new Triple<>(APPROVED, CREATED, "Оформить эксперимент заново")
    );

}
