package javaPro.response;

import javaPro.dto.ProductDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PaymentResponseDto {
    private List<ProductDto> productListDto;
}
