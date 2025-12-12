package cadastro.music.Samba.Musican;

import cadastro.music.Samba.instrument.InstrumentModel;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MusicanDTO {

    private Long id;

    private String name;

    private String image;

    private String contact;


    private InstrumentModel instrument;
}
