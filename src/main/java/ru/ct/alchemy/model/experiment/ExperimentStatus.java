package ru.ct.alchemy.model.experiment;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ExperimentStatus {
    CREATED("Заполнение параметров"),
    FILLED_IN("Параметры заполнены"),
    APPROVED("Согласован"),
    RUNNING("Выполняется"),
    CANCELLED("Отменён"),
    FINISHED("Завершён"),
    REPORTED("Отчёт сформирован"),
    ;

    private final String description;
}
