package hello.itemservice.domain.item;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.hibernate.validator.constraints.Range;
import org.hibernate.validator.constraints.ScriptAssert;

@Data
//@ScriptAssert(lang = "javascript", script = "_this.price * _this.quantity >= 10000", message = "총합이 10000원 넘게 입력해주세요")
// 기능이 제한적이고 약하다.
public class Item {

    private Long id;
    /**
     * BeanValidation 메시지 찾는 순서
     * <p>
     * 1. 생성된 메시지 코드 순서대로 messageSource 에서 메시지 찾기
     * NotBlank.item.itemName
     * NotBlank.itemName
     * NotBlank.java.lang.String
     * NotBlank
     * 2. 애노테이션의 message 속성 사용 @NotBlank(message = "공백! {0}")
     * 3. 라이브러리가 제공하는 기본 값 사용 공백일 수 없습니다.
     */
    @NotBlank(message = "공백!")
    private String itemName;

    @NotNull
    @Range(min = 1000, max = 1000000)
    private Integer price;

    @NotNull
    @Max(9999)
    private Integer quantity;

    public Item() {
    }

    public Item(String itemName, Integer price, Integer quantity) {
        this.itemName = itemName;
        this.price = price;
        this.quantity = quantity;
    }
}
