package spatula.enums;

public enum StandartEnum {
    /*Затраты труда рабочих-строителей*/
    LABOR_COSTS_WORKERS(-1L),
    /*Затраты труда машинистов*/
    LABOR_COSTS_MACHINISTS(-2L),
    /*Прочие машины*/
    OTHER_MACHINES(-3L),
    /*Прочие материалы*/
    OTHER_MATERIALS(-4L);

    private Long id;

    public static boolean exclusion(Long id) {
        for (StandartEnum standartEnum : StandartEnum.values()) {
            if (standartEnum.getId().equals(id)) {
                return true;
            }
        }
        return false;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    private StandartEnum(Long id) {
        this.id = id;
    }

}
