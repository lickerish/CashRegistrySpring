package pl.lickerish.cashregistryspring.DTO;

import lombok.Data;

import java.util.Date;

@Data
public class BillDTO {
    private Integer id;
    private Double amountToPay;
    private Date buyTime;


}
