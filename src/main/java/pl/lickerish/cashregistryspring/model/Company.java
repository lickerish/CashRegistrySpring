package pl.lickerish.cashregistryspring.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity(name = "company")
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "name")
    private String name;
    @Column(name = "ceoName")
    private String ceoName;
    @Column(name = "NIP")
    private String NIP;
}
