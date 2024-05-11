package hello.itemservice.web.validation;

import hello.itemservice.web.validation.form.ItemSaveForm;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/validation/api/items")
public class ValidationItemApiConroller {
    /**
     * API의 경우 3가지 경우를 나누어 생각해야 한다.
     * 1.성공 요청: 성공
     * 2.실패 요청: JSON을 객체로 생성하는 것 자체가 실패함
     * 3.검증 오류 요청: JSON을 객체로 생성하는 것은 성공했고, 검증에서 실패함
     */
    // @Valid , @Validated 는 HttpMessageConverter ( @RequestBody )에도 적용할 수 있다.
    @PostMapping("/add")
    public Object addItem(@RequestBody @Validated ItemSaveForm form, BindingResult bindingResult) {
        log.info("API 컨트롤러 호출"); // 값을 잘못 보내면 -> json 객체가 생성자체가 안 됨 ->컨트롤러 자체가 호출되지 않는다

        if (bindingResult.hasErrors()) { //json 객체까지는 생성을 성공했지만, 검증에서 오류가 검출될때임
            log.info("검증 오류 발생 erroes={}", bindingResult);
            return bindingResult.getAllErrors();
        }

        log.info("성공 로직 실행");
        return form;
    }
    /**
     * @ModelAttribute vs @RequestBody
     *
     * @ModelAttribute 는 필드 단위로 정교하게 바인딩이 적용된다.
     * 특정 필드가 바인딩 되지 않아도 나머지 필드는 정상 바인딩 되고,
     * Validator를 사용한 검증도 적용할 수 있다.
     *
     * @RequestBody 는 HttpMessageConverter 단계에서 JSON 데이터를 객체로 변경하지 못하면,
     * 이후 단계 자체가 진행되지 않고 예외가 발생한다.
     * 컨트롤러도 호출되지 않고, Validator도 적용할 수 없다
     */
    // 참고 : HttpMessageConverter 단계에서 실패하면 예외가 발생한다.
    //       예외 발생시 원하는 모양으로 예외를 처리하는 방법은 예외 처리 부분에서 다룬다.
}
