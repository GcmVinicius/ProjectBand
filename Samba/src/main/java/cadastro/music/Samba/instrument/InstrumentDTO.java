package cadastro.music.Samba.instrument;

import cadastro.music.Samba.Musican.MusicanModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class InstrumentDTO {


    private Long id;

    private String type;


    private String intrument;

    private String brand;

    private int manufacture;

    private MusicanModel musican;

}
