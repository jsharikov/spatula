package spatula.enums;

public enum UnitEnum {

    M3(1L, "м3"),
    MAN_HOUR(2L, "чел-ч"),
    MACHINE_HOUR(3L, "маш-ч"),
    TENGE(4L, "Тенге"),
    M2(5L, "м2"),
    KG(6L, "кг"),
    PC(7L, "шт"),
    T(8L, "т");

    private Long id;
    private String name;

    private UnitEnum(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public static UnitEnum getUnitEnumByName(String name) {
        for (UnitEnum unitEnum : UnitEnum.values()) {
            if (unitEnum.getName().equals(name)) {
                return unitEnum;
            }
        }
        return null;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

}
