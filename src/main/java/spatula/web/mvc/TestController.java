package spatula.web.mvc;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import spatula.entity.Test;
import spatula.parser.WorkParser;
import spatula.service.TestService;
import spatula.service.reference.WorkService;

/**
 * Контроллер для работы с тестовой базой.
 *
 * @author Anastasiya_Trafimava
 *
 */
@Controller
public class TestController {

    @Autowired
    private TestService testService;

    @Autowired
    private WorkService workService;

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public String methodGet(ModelMap model) {
        List<Test> listTest = new ArrayList<>(1);
        listTest.add(testService.getById(1));
        model.addAttribute("listTest", listTest);

        workService.saveWorks(WorkParser.parse());

        return ".test";
    }
}
