package spatula.test.junit;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;

import org.junit.Test;

import spatula.enums.UnitEnum;

public class UnitEnumTest {

    @Test
    public void testGetUnitEnumByName() {
        String[] params = {"т", null, "", "test", "1т"};
        assertSame(UnitEnum.T, UnitEnum.getUnitEnumByName(params[0]));
        assertNull(UnitEnum.getUnitEnumByName(params[1]));
        assertNull(UnitEnum.getUnitEnumByName(params[2]));
        assertNull(UnitEnum.getUnitEnumByName(params[3]));
        assertSame(UnitEnum.T, UnitEnum.getUnitEnumByName(params[4]));
    }

}
