package spatula.web.mvc.standart;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import spatula.entity.standart.Resource;
import spatula.enums.UnitEnum;
import spatula.service.standart.ResourceService;

@Controller
@RequestMapping("/standart/resource")
public class ResourceController {

    @Autowired
    private ResourceService resourceService;

    @Autowired
    @Qualifier("resourceValidator")
    private Validator resourceValidator;

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.addValidators(resourceValidator);
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String showResources(Model model) {
        model.addAttribute("resources", resourceService.getAllNotExclusion());
        return "resource/list";
    }

    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public String showAddForm(Model model) {
        model.addAttribute("resource", new Resource());
        model.addAttribute("units", UnitEnum.getUnits());
        return "resource/create";
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public String showUpdateForm(@PathVariable("id") Long resourceId, Model model) {
        model.addAttribute("resource", resourceService.get(resourceId));
        model.addAttribute("units", UnitEnum.getUnits());
        return "resource/update";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveResource(@Valid Resource resource, BindingResult result,
            Model model) {
        if (result.hasErrors()) {
            model.addAttribute("resource", resource);
            model.addAttribute("units", UnitEnum.getUnits());
            return createOrUpdateView(resource.getId());
        }
        resourceService.saveWithStandart(resource);
        return "redirect:/standart/resource";
    }

    private String createOrUpdateView(Long id) {
        if (id == null) {
            return "resource/create";
        } else {
            return "resource/update";
        }
    }

}
