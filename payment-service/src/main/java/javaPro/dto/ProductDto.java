package javaPro.dto;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class ProductDto {
    private Long id;
    private String accountNumber;
    private BigDecimal balance;
    private String typeProducts;
    private Long user;


    public ProductDto(
            Long id,
            String accountNumber,
            BigDecimal balance,
            String typeProducts,
            Long user)
    {
        this.id = id;
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.typeProducts = typeProducts;
        this.user = user;
    }

    @Override
    public String toString() {
        return "ProductDto{" +
                "id=" + id +
                ", accountNumber='" + accountNumber + '\'' +
                ", balance=" + balance +
                ", typeProducts='" + typeProducts + '\'' +
                ", user=" + user +
                '}';
    }
}
