package spatula.enums;

import java.util.ArrayList;
import java.util.List;

import spatula.entity.standart.WorkType;

public enum WorkTypeEnum {
    FLOOR(1L, "Полы"),
    WALL(2L, "Стены"),
    FOUNDATION(3L, "Фундаменты");

    private Long id;
    private String name;

    private WorkTypeEnum(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public static List<WorkType> getWorkTypes() {
        List<WorkType> workTypes = new ArrayList<>(WorkTypeEnum.values().length);
        for (WorkTypeEnum workTypeEnum : WorkTypeEnum.values()) {
            WorkType workType = new WorkType();
            workType.setId(workTypeEnum.getId());
            workType.setName(workTypeEnum.getName());
            workTypes.add(workType);
        }
        return workTypes;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }


}
