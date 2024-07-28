package ru.ct.alchemy.model.experiment;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ExperimentStatus {
    CREATED("Создан"),
    FILLED_IN("Данные заполнены"),
    APPROVED("Согласован"),
    RUNNING("Выполняется"),
    CANCELLED("Отменён"),
    FINISHED("Завершён"),
    REPORTED("Отчёт сформирован"),
    ;

    private final String description;
}
