package javaPro.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;

public class PaymentDto {
        @JsonProperty("product_id")
        Long productId;
        @JsonProperty("user_id")
        Long userId;
        @JsonProperty("account_number")
        String accountNumber;
        @JsonProperty("sum_pay")
        BigDecimal sumPay;

    public PaymentDto(Long productId, Long userId, String accountNumber, BigDecimal sumPay) {
        this.productId = productId;
        this.userId = userId;
        this.accountNumber = accountNumber;
        this.sumPay = sumPay;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public BigDecimal getSumPay() {
        return sumPay;
    }

    public void setSumPay(BigDecimal sumPay) {
        this.sumPay = sumPay;
    }

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
