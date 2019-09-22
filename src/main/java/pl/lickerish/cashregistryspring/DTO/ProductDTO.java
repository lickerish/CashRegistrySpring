package pl.lickerish.cashregistryspring.DTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ProductDTO {
    private Integer id;
    private String productName;
    private String productNumber;
    private Double price;

    @Builder
    public ProductDTO(String productName, String productNumber, Double price) {
        this.productName = productName;
        this.productNumber = productNumber;
        this.price = price;
    }
}
