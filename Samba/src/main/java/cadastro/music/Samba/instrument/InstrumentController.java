package cadastro.music.Samba.instrument;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/instrument")
public class InstrumentController {

    private final InstrumentService instrumentService;

    public InstrumentController(InstrumentService instrumentService) {
        this.instrumentService = instrumentService;
    }

    @GetMapping("/list")
    public ResponseEntity<List<InstrumentDTO>> InstrumentDTO(){
        List<InstrumentDTO> instrument = instrumentService.listInstruments();
        return ResponseEntity.ok(instrument);
    }

    @GetMapping("/list/{id}")
    public ResponseEntity<?> listById(@PathVariable Long id){

        InstrumentDTO instrument = instrumentService.listInsById(id);

        if (instrument != null){
            return ResponseEntity.ok(instrument);


        }else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Instrument not found");
        }

    }


    @PostMapping("/create")
    public  ResponseEntity<String> createInstrument(@RequestBody InstrumentDTO instrumentDTO){
    InstrumentDTO instrumentNew = instrumentService.createInstrument(instrumentDTO);
    return ResponseEntity.status(HttpStatus.CREATED)
            .body("Sucefull create");
    }



    @DeleteMapping("/delete")
    public  ResponseEntity<String> deletById(@PathVariable Long id){
    if (instrumentService.listInsById(id) != null){
    instrumentService.deletInstrumentId(id);
    return ResponseEntity.ok("Instrument deleted of the list!");

    } else {
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body("not found...");
    }
    }

    @PostMapping("/edit/{id}")
    public ResponseEntity<?> editInstrument(@PathVariable Long id, @RequestBody InstrumentDTO instrumentEdit){
    InstrumentDTO instrument = instrumentService.editInstruments(id, instrumentEdit);
    if (instrument != null){
        return ResponseEntity.ok(instrument);
    } else
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body("Not found...");

    }
}
