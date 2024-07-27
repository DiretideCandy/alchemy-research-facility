package ru.ct.alchemy.presentation.initdata;

import lombok.Getter;
import org.springframework.stereotype.Component;
import ru.ct.alchemy.presentation.initdata.tuples.Pair;
import ru.ct.alchemy.presentation.initdata.tuples.Triple;

import java.util.List;

@Component
@Getter
public class Data {

    private final List<Pair<String, String>> statusList = List.of(
            new Pair<>("CREATED", "Создан"),
            new Pair<>("FILLED_IN", "Данные заполнены"),
            new Pair<>("APPROVED", "Согласован"),
            new Pair<>("RUNNING", "Выполняется"),
            new Pair<>("CANCELLED", "Отменён"),
            new Pair<>("FINISHED", "Завершён"),
            new Pair<>("REPORTED", "Отчёт сформирован")
    );

    private final List<Triple<String, String, String>> workflow = List.of(
            // основной процесс
            new Triple<>("CREATED", "FILLED_IN", "Заполнить все поля"),
            new Triple<>("FILLED_IN", "APPROVED", "Согласовать проведение эксперимента"),
            new Triple<>("APPROVED", "RUNNING", "Начать проводить эксперимент"),
            new Triple<>("RUNNING", "FINISHED", "Завершить проведение эксперимента"),
            new Triple<>("FINISHED", "REPORTED", "Сформировать отчёт"),
            // отмена из почти любого статуса
            new Triple<>("CREATED", "CANCELLED", "Отменить созданный эксперимент"),
            new Triple<>("FILLED_IN", "CANCELLED", "Отменить созданный эксперимент"),
            new Triple<>("APPROVED", "CANCELLED", "Отменить согласованный эксперимент"),
            new Triple<>("RUNNING", "CANCELLED", "Отменить проводящийся эксперимент"),
            new Triple<>("FINISHED", "CANCELLED", "Отменить завершённый эксперимент"),
            // переходы на предыдущий статус до начала эксперимента
            new Triple<>("FILLED_IN", "CREATED", "Оформить эксперимент заново"),
            new Triple<>("APPROVED", "CREATED", "Оформить эксперимент заново")
    );

}
