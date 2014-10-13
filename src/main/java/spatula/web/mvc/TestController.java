package spatula.web.mvc;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import spatula.entity.Test;
import spatula.service.TestService;

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

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public String methodGet(ModelMap model) {
        List<Test> listTest = new ArrayList<>(1);
        listTest.add(testService.getById(1));
        model.addAttribute("listTest", listTest);
        return ".test";
    }
}
