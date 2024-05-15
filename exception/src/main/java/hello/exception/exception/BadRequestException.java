package hello.exception.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

// 내부적으로 지금까지 한 것처럼 되어 있다.
// reason = "잘못된 요청 오류") 처럼 써도 되고,
// MessageSource 에서 찾는 기능도 제공한다.
@ResponseStatus(code = HttpStatus.BAD_REQUEST, reason = "error.bad")
public class BadRequestException extends RuntimeException {

}
