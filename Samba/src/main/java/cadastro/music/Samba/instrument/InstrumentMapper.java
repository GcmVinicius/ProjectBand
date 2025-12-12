package cadastro.music.Samba.instrument;

import org.springframework.stereotype.Component;

@Component
public class InstrumentMapper {
    public InstrumentModel map(InstrumentDTO instrumentDTO) {
        if (instrumentDTO == null) {
            return null;
        }

        InstrumentModel instrumentModel = new InstrumentModel();

        instrumentModel.setId(instrumentDTO.getId());
        instrumentModel.setType(instrumentDTO.getType());
        instrumentModel.setInstrument(instrumentDTO.getInstrument());
        instrumentModel.setBrand(instrumentDTO.getBrand());
        instrumentModel.setManufacture(instrumentDTO.getManufacture());
        instrumentModel.setImge(null);
        instrumentModel.setMusican(instrumentDTO.getMusican());

        return instrumentModel;
    }

    public InstrumentDTO map(InstrumentModel instrumentModel) {
        if (instrumentModel == null) {
            return null;
        }

        InstrumentDTO instrumentDTO = new InstrumentDTO();

        instrumentDTO.setId(instrumentModel.getId());
        instrumentDTO.setType(instrumentModel.getType());
        instrumentDTO.setInstrument(instrumentModel.getInstrument());
        instrumentDTO.setBrand(instrumentModel.getBrand());
        instrumentDTO.setManufacture(instrumentModel.getManufacture());
        instrumentDTO.setMusican(instrumentModel.getMusican());

        return instrumentDTO;
    }
}
