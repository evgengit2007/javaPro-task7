package javaPro.dto;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter @Setter
public class ProductDto {
    private final Long productId;
    private final Long userId;
    private final String accountNumber;
    private final BigDecimal balance;

    public ProductDto(Long productId, Long userId, String accountNumber, BigDecimal balance) {
        this.productId = productId;
        this.userId = userId;
        this.accountNumber = accountNumber;
        this.balance = balance;
    }


}
