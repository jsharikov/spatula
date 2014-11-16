package spatula.test.junit;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({
        //BankServiceTest.class,
        ResourceServiceTest.class,
        WorkServiceTest.class
})
public class SuiteTests {

}
