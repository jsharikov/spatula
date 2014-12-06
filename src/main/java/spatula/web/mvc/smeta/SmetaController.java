package spatula.web.mvc.smeta;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import spatula.entity.smeta.Smeta;
import spatula.entity.smeta.WorkSmeta;
import spatula.parser.WorkParser;
import spatula.service.smeta.SmetaService;
import spatula.service.standart.WorkService;
import spatula.web.mvc.multipart.UploadFile;

@Controller
@RequestMapping("/smeta")
public class SmetaController {

    @Autowired
    private SmetaService smetaService;
    @Autowired
    private WorkService workService;
    @Autowired
    private WorkParser workParser;

    @RequestMapping
    public String showSmetaList(Model model) {
        model.addAttribute("smetaList", smetaService.getAll());
        return "smeta/list";
    }

    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public String showAddForm(Model model) {
        SmetaForm smetaForm = new SmetaForm();
        model.addAttribute("smetaForm", smetaForm);
        model.addAttribute("works", workService.getAll());
        return "smeta/create";
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public String showUpdateForm(@PathVariable("id") Long smetaId, Model model) {
        SmetaForm smetaForm = new SmetaForm();
        smetaForm.setSmeta(smetaService.get(smetaId));
        model.addAttribute("smetaForm", smetaForm);
        model.addAttribute("works", workService.getAll());
        return "smeta/create";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveSmeta(SmetaForm smetaForm, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "smeta/create";
        }
        smetaForm.getSmeta().getWorks().add(smetaForm.getWorkSmeta());
        if (smetaForm.getSmeta().getId() == null) {
            smetaService.create(smetaForm.getSmeta());
        } else {
            smetaService.update(smetaForm.getSmeta());
        }
        return "redirect:/smeta/" + smetaForm.getSmeta().getId();
    }

    @RequestMapping(value = "/import", method = RequestMethod.GET)
    public String showImportForm(Model model) {
        model.addAttribute("uploadFile", new UploadFile());
        return "smeta/import";
    }

    @RequestMapping(value = "/import", method = RequestMethod.POST)
    public String saveFile(UploadFile uploadFile, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "smeta/import";
        }
        try {
            List<WorkSmeta> workSmetaList = workParser.parse(uploadFile.getFile().getBytes());
            Smeta smeta = new Smeta();
            smeta.setWorks(workSmetaList);
            smetaService.create(smeta);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return "redirect:/smeta/import";
    }

}
