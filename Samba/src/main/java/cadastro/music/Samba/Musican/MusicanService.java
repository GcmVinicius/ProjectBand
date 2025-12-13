package cadastro.music.Samba.Musican;

import cadastro.music.Samba.instrument.InstrumentDTO;
import cadastro.music.Samba.instrument.InstrumentMapper;
import cadastro.music.Samba.instrument.InstrumentModel;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MusicanService {

    private final MusicanRepository musicanRepository;
    private final MusicanMapper musicanMapper;

    public MusicanService(MusicanRepository musicanRepository, MusicanMapper musicanMapper) {
        this.musicanRepository = musicanRepository;
        this.musicanMapper = musicanMapper;
    }
    //List
    public List<MusicanDTO> listMusican(){
        List<MusicanModel> musican =musicanRepository.findAll();
        return musican.stream()
                .map(musicanMapper::map)
                .collect(Collectors.toList());
    }

    //ListbyId
    public MusicanDTO listMusById(Long id){
        Optional<MusicanModel> musican = musicanRepository.findById(id);
        return musican.map(musicanMapper::map).orElse(null);
    }

    //Create
    public MusicanDTO createMusican(MusicanDTO musicanDTO){
        MusicanModel musican = musicanMapper.map(musicanDTO);
        musican = musicanRepository.save(musican);
        return musicanMapper.map(musican);
    }

    //Delete
    public void deletMusicanId(Long id){
        musicanRepository.deleteById(id);
    }

    public MusicanDTO editMusican(Long id, MusicanDTO musicanDTO){
        Optional<MusicanModel> musicanE = musicanRepository.findById(id);
        if (musicanE.isPresent()){
            MusicanModel musicanNew = musicanMapper.map(musicanDTO);
            musicanNew.setId(id);
            MusicanModel musicanSave = musicanRepository.save(musicanNew);
            return musicanMapper.map(musicanSave);
        }
        return null;
    }
}
