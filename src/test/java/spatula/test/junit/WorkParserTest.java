package spatula.test.junit;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import spatula.entity.smeta.Smeta;
import spatula.entity.smeta.WorkSmeta;
import spatula.parser.WorkParser;
import spatula.service.smeta.SmetaService;

public class WorkParserTest extends AbstractServiceTest {

    @Autowired
    private SmetaService smetaService;

    @Test
    public void testParse() {
        //List<WorkSmeta> works = WorkParser.parse();
        Smeta smeta = new Smeta();
        //smeta.setWorks(works);
        smetaService.create(smeta);
        //System.out.println(works);
    }

}
