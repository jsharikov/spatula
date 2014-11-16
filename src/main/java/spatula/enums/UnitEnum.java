package spatula.enums;

import java.util.ArrayList;
import java.util.List;

import spatula.entity.reference.Unit;

public enum UnitEnum {

    M3(1L, "м3"),
    MAN_HOUR(2L, "чел-ч"),
    MACHINE_HOUR(3L, "маш-ч"),
    TENGE(4L, "Тенге"),
    M2(5L, "м2"),
    KG(6L, "кг"),
    PC(7L, "шт"),
    T(8L, "т;1т"),
    M(9L, "м"),
    PC1000(10L, "1000шт");

    private Long id;
    private String name;

    private UnitEnum(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public static UnitEnum getUnitEnumByName(String name) {
        for (UnitEnum unitEnum : UnitEnum.values()) {
            for (String separatedName : unitEnum.getName().split(";")) {
                if (separatedName.equals(name)) {
                    return unitEnum;
                }
            }
        }
        return null;
    }

    public static List<Unit> getUnits() {
        List<Unit> units = new ArrayList<>(UnitEnum.values().length);
        for (UnitEnum unitEnum : UnitEnum.values()) {
            Unit unit = new Unit();
            unit.setId(unitEnum.getId());
            unit.setName(unitEnum.getName());
            units.add(unit);
        }
        return units;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

}
