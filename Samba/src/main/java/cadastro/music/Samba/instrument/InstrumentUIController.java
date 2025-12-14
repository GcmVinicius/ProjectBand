package cadastro.music.Samba.instrument;

import cadastro.music.Samba.Musican.MusicanService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/ui/instruments")
public class InstrumentUIController {

    private final InstrumentService instrumentService;
    private final MusicanService musicanService;

    public InstrumentUIController(InstrumentService instrumentService, MusicanService musicanService) {
        this.instrumentService = instrumentService;
        this.musicanService = musicanService;
    }

    @GetMapping
    public String listInstruments(Model model) {
        model.addAttribute("instruments", instrumentService.listInstruments());
        return "instrument/instrument-list";
    }

    @GetMapping("/new")
    public String showCreateForm(Model model) {
        model.addAttribute("instrument", new InstrumentDTO());
        model.addAttribute("musicans", musicanService.listMusican());
        model.addAttribute("isEdit", false);
        return "instrument/instrument-form";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        InstrumentDTO instrumentDTO = instrumentService.listInsById(id);
        if (instrumentDTO == null) {
            return "redirect:/ui/instruments";
        }
        model.addAttribute("instrument", instrumentDTO);
        model.addAttribute("musicans", musicanService.listMusican());
        model.addAttribute("isEdit", true);
        return "instrument/instrument-form";
    }
}