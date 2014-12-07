package spatula.web.mvc.standart.work;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import spatula.entity.standart.Resource;
import spatula.entity.standart.ResourceWork;
import spatula.entity.standart.Work;
import spatula.enums.StandartEnum;
import spatula.enums.UnitEnum;
import spatula.enums.WorkTypeEnum;
import spatula.service.standart.ResourceService;
import spatula.service.standart.StandartService;
import spatula.service.standart.WorkService;

@Controller
@RequestMapping("/standart/work")
public class WorkController {

    enum SubmitEnum {
        ADD_RESOURCE,
        GET_RESOURCE_INFO,
        REMOVE_RESOURCE;
    }

    @Autowired
    private WorkService workService;
    @Autowired
    private ResourceService resourceService;
    @Autowired
    private StandartService standartService;

    @Autowired
    @Qualifier("workValidator")
    private Validator workValidator;

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.addValidators(workValidator);
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String showResources(Model model) {
        List<Work> works = workService.getAll();
        model.addAttribute("works", works);
        return "work/list";
    }

    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public String showAddForm(Model model) {
        model.addAttribute("work", new Work());
        model.addAttribute("units", UnitEnum.getUnits());
        model.addAttribute("workTypes", WorkTypeEnum.getWorkTypes());
        return "work/create";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveResource(@Valid Work work, BindingResult result, SubmitEnum sbmt,
            Integer removedResourceIndex, Model model) {

        if (sbmt != null) {
            switch (sbmt) {
                case ADD_RESOURCE:
                    work.getResources().add(new ResourceWork());
                    break;
                case GET_RESOURCE_INFO:
                    for (ResourceWork resourceWork : work.getResources()) {
                        Long standartId = resourceWork.getResource().getStandartId();
                        if (StandartEnum.exclusion(standartId)) {
                            Resource resource = new Resource();
                            resource.setStandart(standartService.get(standartId));
                            resource.setStandartId(standartId);
                            resource.setCost(resourceWork.getResource().getCost());
                            resourceWork.setResource(resource);
                        } else {
                            resourceWork.setResource(resourceService.getByStandartId(standartId));
                        }
                    }
                    break;
                case REMOVE_RESOURCE:
                    work.getResources().remove(removedResourceIndex.intValue());
                    break;
                default:
                    break;
            }
        }
        /*if (work.getResources()!=null && !work.getResources().isEmpty()) {
            BigDecimal totalMachineQuantity = BigDecimal.ZERO;
            BigDecimal sumWagesOfMachinists = BigDecimal.ZERO;
            BigDecimal sumOperMachines = BigDecimal.ZERO;
            BigDecimal sumMaterials = BigDecimal.ZERO;
            for (ResourceWork resourceWork : work.getResources()) {
                Long standartId = resourceWork.getResource().getStandartId();
                if (standartId != null) {
                    if (standartId.equals(StandartEnum.LABOR_COSTS_WORKERS.getId())) {
                        if (resourceWork.getQuantity() != null
                                && resourceWork.getResource().getCost() != null) {
                            work.setWagesOfWorkers(resourceWork.getQuantity().multiply(
                                    resourceWork.getResource().getCost()));
                        }
                    } else {
                        Resource resource = resourceService.getByStandartId(standartId);
                        if (resource.getMachine() != null) {
                            if (resource.getMachine()) {
                            if (resourceWork.getQuantity() != null
                                    && resourceWork.getResource().getCost() != null) {
                                sumWagesOfMachinists = sumWagesOfMachinists.add(resourceWork.getQuantity().multiply(resource.getWageOfMachinist()));
                                totalMachineQuantity = totalMachineQuantity.add(resourceWork.getQuantity());
                                sumOperMachines = sumOperMachines.add(resourceWork.getQuantity().multiply(resourceWork.getResource().getCost()));
                            }} else {
                                if (resourceWork.getQuantity() != null
                                        && resourceWork.getResource().getCost() != null) {
                                    sumMaterials = sumMaterials.add(resourceWork.getQuantity().multiply(resourceWork.getResource().getCost()));
                                }
                            }
                        }
                    }
                }
            }
            work.setOperMachinesCost(sumOperMachines);
            work.setIncludingWagesOfMachinists(sumWagesOfMachinists);
            BigDecimal totalCost = sumOperMachines.add(sumMaterials);
            if (work.getWagesOfWorkers() != null) {
                totalCost = totalCost.add(work.getWagesOfWorkers());
            }
            work.setTotalCost(totalCost);
            
        }*/
        if (sbmt != null || result.hasErrors()) {
            model.addAttribute("units", UnitEnum.getUnits());
            model.addAttribute("workTypes", WorkTypeEnum.getWorkTypes());
            model.addAttribute("standarts", standartService.getAll());
            return work.getId() == null ? "work/create" : "work/update";
        }
        workService.save(work);
        return "redirect:/standart/work";
    }

}
