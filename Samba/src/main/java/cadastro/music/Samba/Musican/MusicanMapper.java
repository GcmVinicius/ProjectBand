package cadastro.music.Samba.Musican;


import org.springframework.stereotype.Component;

@Component
public class MusicanMapper {
    public MusicanModel map(MusicanDTO musicanDTO) {
        if (musicanDTO == null) {
            return null;
        }

        MusicanModel musicanModel = new MusicanModel();

        musicanModel.setId(musicanDTO.getId());
        musicanModel.setName(musicanDTO.getName());
        musicanModel.setImage(musicanDTO.getImage());
        musicanModel.setContact(musicanDTO.getContact());
        musicanModel.setInstrument(musicanDTO.getInstrument());

        return musicanModel;
    }

    public MusicanDTO map(MusicanModel musicanModel) {
        if (musicanModel == null) {
            return null;
        }

        MusicanDTO musicanDTO = new MusicanDTO();

        musicanDTO.setId(musicanModel.getId());
        musicanDTO.setName(musicanModel.getName());
        musicanDTO.setImage(musicanModel.getImage());
        musicanDTO.setContact(musicanModel.getContact());
        musicanDTO.setInstrument(musicanModel.getInstrument());

        return musicanDTO;
    }
}
