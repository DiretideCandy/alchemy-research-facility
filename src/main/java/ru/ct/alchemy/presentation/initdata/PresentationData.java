package ru.ct.alchemy.presentation.initdata;

import lombok.Getter;
import org.springframework.stereotype.Component;
import ru.ct.alchemy.model.Action;
import ru.ct.alchemy.model.experiment.ExperimentStatus;
import ru.ct.alchemy.model.inventory.Equipment;
import ru.ct.alchemy.model.inventory.EquipmentType;
import ru.ct.alchemy.model.inventory.Material;
import ru.ct.alchemy.model.inventory.MaterialType;
import ru.ct.alchemy.model.security.Role;
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

    private final List<Material> materials = List.of(
            Material.builder().type(MaterialType.METAL).name("Зачарованная медь").amount(19).build(),
            Material.builder().type(MaterialType.FAUNA).name("Клык дракона").amount(2).build(),
            Material.builder().type(MaterialType.FAUNA).name("Коготь дракона").amount(5).build(),
            Material.builder().type(MaterialType.FAUNA).name("Чешуйка дракона").amount(20).build(),
            Material.builder().type(MaterialType.FLORA).name("Шип камнеломки").amount(22).build(),
            Material.builder().type(MaterialType.POTION).name("Зелье невидимости, 50 мл").amount(23).build()
    );

    private final List<Equipment> equipment = List.of(
            Equipment.builder().type(EquipmentType.HAMMER).name("Кузнечный молот, +5 к кузнечному делу").amount(8).build(),
            Equipment.builder().type(EquipmentType.CAULDRON).name("Котёл чугунный, крупный").amount(9).build(),
            Equipment.builder().type(EquipmentType.WAND).name("Волшебная палочка, волос единорога, бук").amount(10).build()
    );

    private final List<Action> actions = List.of(
            Action.builder().equipmentType(EquipmentType.HAMMER).name("Разбить").build(),
            Action.builder().equipmentType(EquipmentType.HAMMER).name("Ковать").build(),
            Action.builder().equipmentType(EquipmentType.WAND).name("Ткнуть").build(),
            Action.builder().equipmentType(EquipmentType.WAND).name("Зачарование").build(),
            Action.builder().equipmentType(EquipmentType.WAND).name("Заклинание \"Трансформация\"").build(),
            Action.builder().equipmentType(EquipmentType.CAULDRON).name("Варка").build(),
            Action.builder().equipmentType(EquipmentType.CAULDRON).name("Смешивание").build()
    );

    private final List<Role> roles = List.of(
            Role.builder().name("SYSTEM_ADMIN").build(),
            Role.builder().name("SCIENTIST").build(),
            Role.builder().name("MANAGER").build(),
            Role.builder().name("API").build()
    );

}
