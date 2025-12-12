package cadastro.music.Samba.Musican;


import cadastro.music.Samba.instrument.InstrumentModel;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@Entity
@Table(name = "musican")
@Data
@AllArgsConstructor
@NoArgsConstructor

public class MusicanModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="id")
    private Long id;

    @Column(name = "Name")
    private String name;

    @Column(name = "Img")
    private String image;

    @Column(name = "Contact")
    private String contact;

    @OneToOne(mappedBy = "musican", cascade = CascadeType.ALL)
    @JsonIgnore
    private InstrumentModel instrument;
}
