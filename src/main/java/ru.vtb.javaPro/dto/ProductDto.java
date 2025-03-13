package ru.vtb.javaPro.dto;

import java.math.BigDecimal;

public record ProductDto(
        Long id,
        String accountNumber,
        BigDecimal balance,
        String typeProducts,
        Long userId)
{
    @Override
    public String toString() {
        return "ProductDto{" +
                "id=" + id +
                ", accountNumber='" + accountNumber + '\'' +
                ", balance=" + balance +
                ", typeProducts='" + typeProducts + '\'' +
                ", userId=" + userId +
                '}';
    }
}
