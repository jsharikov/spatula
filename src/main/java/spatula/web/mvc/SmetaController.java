/*package spatula.web.mvc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import spatula.entity.Smeta;
import spatula.entity.reference.Work;
import spatula.service.SmetaService;
import spatula.service.reference.WorkService;

@Controller
@RequestMapping("/smeta")
public class SmetaController {

    @Autowired
    private SmetaService smetaService;
    @Autowired
    private WorkService workService;

    @RequestMapping
    public String showSmetaList(Model model) {
        model.addAttribute("smetaList", smetaService.getAll());
        return ".smetaList";
    }

    @RequestMapping(value = "/{smetaId}")
    public String showSmeta(@PathVariable("smetaId") Long smetaId, Model model) {
        Smeta smeta = smetaService.get(smetaId);
        model.addAttribute("smeta", smeta);
        return ".smeta";
    }

    @RequestMapping(value = "/new")
    public String create() {
        smetaService.save(new Smeta());
        return "redirect:";
    }

    @RequestMapping(value = "/{smetaId}/work/new")
    public String showWorkForm(@PathVariable("smetaId") Long smetaId, Model model) {
        model.addAttribute("standarts", workService.getStandartWorks());
        model.addAttribute("work", new Work());
        return ".work";
    }

    @RequestMapping(value = "/{smetaId}/work/new", method = RequestMethod.POST)
    public String createWork(@PathVariable("smetaId") Long smetaId, Work work) {
        workService.save(work);
        return "redirect:/smeta/" + smetaId;
    }
}
*/