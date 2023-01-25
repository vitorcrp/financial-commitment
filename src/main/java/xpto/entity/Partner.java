package xpto.entity;

import jakarta.persistence.Table;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Column;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@Entity
@Table(name = "PARTNER")
@NoArgsConstructor
public class Partner {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false)
    private int id;

    @Column(name = "IDPERSON",  nullable = false)
    private Integer idPerson;

    @Column(name = "IDPARTNER", nullable = false)
    private Integer idPartner;

    public Partner(int id, Integer idPerson, Integer idPartner) {
        this.id = id;
        this.idPerson = idPerson;
        this.idPartner = idPartner;
    }
}
