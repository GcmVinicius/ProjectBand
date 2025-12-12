package cadastro.music.Samba.instrument;

import cadastro.music.Samba.Musican.MusicanModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name = "Instruments")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString(exclude = "musican")
public class InstrumentModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "Type")
    private String type;

    @Column(name = "instrument")
    private String instrument;

    @Column(name = "brand")
    private String brand;


    @Column(name = "Year manufacture")
    private int manufacture;

    @Column(name = "Imge")
    private String imge;

    @OneToOne
    @JoinColumn(name = "musican")
    private MusicanModel musican;
}
