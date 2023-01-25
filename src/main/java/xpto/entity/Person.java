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
@Table(name = "PERSON")
@NoArgsConstructor
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false)
    private Long id;

    @Column(name = "CPFCNPJ", length = 14, nullable = false)
    private String cpfCnpj;

    @Column(name = "PROPERTIES", nullable = false)
    private Integer properties;

    @Column(name = "PERSONTYPE", length = 2, nullable = false)
    private PersonTypeEnum personTypeEnum;

    public Person(Long id, String cpfCnpj, Integer properties) {
        this.id = id;
        this.cpfCnpj = cpfCnpj;
        this.properties = properties;
    }
}