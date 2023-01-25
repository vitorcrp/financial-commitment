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
    private Long id;

    @Column(name = "IDPESSOA",  nullable = false)
    private Integer idPessoa;

    @Column(name = "IDPARTNER", nullable = false)
    private Integer idPartner;

    public Partner(Long id, Integer idPessoa, Integer idPartner) {
        this.id = id;
        this.idPessoa = idPessoa;
        this.idPartner = idPartner;
    }
}
