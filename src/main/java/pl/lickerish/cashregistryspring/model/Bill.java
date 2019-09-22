package pl.lickerish.cashregistryspring.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity(name = "bill")
public class Bill {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "amountToPay")
    private Double amountToPay;
    @Column(name = "buyTime")
    private Date buyTime;
}
