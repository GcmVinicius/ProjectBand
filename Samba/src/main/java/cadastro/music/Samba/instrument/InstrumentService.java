package cadastro.music.Samba.instrument;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class InstrumentService {

    private final InstrumentRepository instrumentRepository;
    private final InstrumentMapper instrumentMapper;

    public InstrumentService(InstrumentRepository instrumentRepository, InstrumentMapper instrumentMapper) {
        this.instrumentRepository = instrumentRepository;
        this.instrumentMapper = instrumentMapper;
    }

    //List
    public List<InstrumentDTO> listInstruments(){
        List<InstrumentModel> instrument =instrumentRepository.findAll();
        return instrument.stream()
                .map(instrumentMapper::map)
                .collect(Collectors.toList());
    }

    //ListbyId
    public InstrumentDTO listInsById(Long id){
        Optional<InstrumentModel> instrument = instrumentRepository.findById(id);
        return instrument.map(instrumentMapper::map).orElse(null);
    }

    //Create
    public InstrumentDTO createInstrument(InstrumentDTO instrumentDTO){
        InstrumentModel instrument = instrumentMapper.map(instrumentDTO);
        instrument = instrumentRepository.save(instrument);
        return instrumentMapper.map(instrument);
    }

    //Delete
    public void deletInstrumentId(Long id){
    instrumentRepository.deleteById(id);
    }

    public InstrumentDTO editInstruments(Long id, InstrumentDTO instrumentDTO){
        Optional<InstrumentModel> instrumentE = instrumentRepository.findById(id);
        if (instrumentE.isPresent()){
        InstrumentModel instrumentNew = instrumentMapper.map(instrumentDTO);
        instrumentNew.setId(id);
        InstrumentModel instrumentSave = instrumentRepository.save(instrumentNew);
        return instrumentMapper.map(instrumentSave);
    }
        return null;
    }



}

