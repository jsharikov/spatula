package spatula.test.junit;

import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;

@ContextConfiguration(locations = {
        "classpath:spring/service.xml",
        "classpath:spring/dao.xml",
        "classpath:spring/aspect.xml",
        "classpath:spring/security.xml",
        "classpath:spring/test.xml",
        })
public abstract class AbstractServiceTest extends AbstractTransactionalJUnit4SpringContextTests {

}
