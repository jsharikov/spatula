package spatula.test.junit.factory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import spatula.entity.standart.Standart;
import spatula.enums.UnitEnum;
import spatula.service.standart.StandartService;

@Component
public class StandartEntityFactory {

    @Autowired
    private StandartService standartService;

    public Standart createStandart() {
        Standart standart = new Standart();
        standart.setCode("code" + TestUtils.getCounterString());
        standart.setName("name");
        standart.setUnitId(UnitEnum.M3.getId());
        standartService.save(standart);
        return standart;
    }

}
