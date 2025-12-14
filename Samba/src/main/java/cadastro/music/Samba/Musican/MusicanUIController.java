package cadastro.music.Samba.Musican;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/ui/musicans")
public class MusicanUIController {

    private final MusicanService musicanService;

    public MusicanUIController(MusicanService musicanService) {
        this.musicanService = musicanService;
    }

    @GetMapping
    public String listMusicans(Model model) {
        model.addAttribute("musicans", musicanService.listMusican());
        return "musican/musican-list";
    }

    @GetMapping("/new")
    public String showCreateForm(Model model) {
        model.addAttribute("musican", new MusicanDTO());
        model.addAttribute("isEdit", false);
        return "musican/musican-form";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        MusicanDTO musicanDTO = musicanService.listMusById(id);
        if (musicanDTO == null) {
            return "redirect:/ui/musicans";
        }
        model.addAttribute("musican", musicanDTO);
        model.addAttribute("isEdit", true);
        return "musican/musican-form";
    }

}