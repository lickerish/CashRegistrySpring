package pl.lickerish.cashregistryspring.DTO;

import lombok.Data;

@Data
public class CompanyDTO {

    private Integer id;
    private String name;
    private String ceoName;
    private String NIP;
}
