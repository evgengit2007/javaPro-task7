package ru.vtb.javaPro.dto;

import java.math.BigDecimal;

public record PaymentDto(
        Long productId,
        Long userId,
        String accountNumber,
        BigDecimal sumPay
) {
    @Override
    public String toString() {
        return "PaymentDto{" +
                "productId=" + productId +
                ", userId=" + userId +
                ", accountNumber='" + accountNumber + '\'' +
                ", sumPay=" + sumPay +
                '}';
    }
}
