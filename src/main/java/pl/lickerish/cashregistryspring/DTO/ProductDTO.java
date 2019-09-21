package pl.lickerish.cashregistryspring.DTO;

import lombok.Data;

@Data
public class ProductDTO {
    private Integer id;
    private String productNumber;
    private Double price;
}
