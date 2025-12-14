package cadastro.music.Samba.Musican;

import cadastro.music.Samba.instrument.InstrumentDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/musican")
public class MusicanController {

    public final MusicanService musicanService;



    public MusicanController(MusicanService musicanService) {
        this.musicanService = musicanService;
    }

    @GetMapping("/list")
    public ResponseEntity<List<MusicanDTO>> listMusican(){
        List<MusicanDTO> musican = musicanService.listMusican();
        return ResponseEntity.ok(musican);
    }

    @GetMapping("/list/{id}")
    public ResponseEntity<?> listById(@PathVariable Long id){
        MusicanDTO musican = musicanService.listMusById(id);
        if (musican != null){
            return ResponseEntity.ok(musican);
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Not found ...");
        }
    }

    @PostMapping("/add")
    public ResponseEntity<String> addMusican(@RequestBody MusicanDTO musican){
        MusicanDTO musicanNew = musicanService.createMusican(musican);
            return ResponseEntity.status(HttpStatus.CREATED)
                    .body("Musican add");
    }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteById(@PathVariable Long id){
    if (musicanService.listMusById(id) != null){
        musicanService.deletMusicanId(id);
        return ResponseEntity.ok("Musican removed");
    } else {
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body("Not found");
    }
    }

    @PostMapping("/edit/{id}")
    public ResponseEntity<?> editById(@PathVariable Long id, @RequestBody MusicanDTO musicanDTO){
        MusicanDTO musican = musicanService.editMusican(id, musicanDTO);
        if (musican != null){
            return ResponseEntity.ok(musican);

        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Not found");
        }
    }

}
