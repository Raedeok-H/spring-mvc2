package hello.exception.resolver;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;

@Slf4j
public class MyHandlerExceptionResolver implements HandlerExceptionResolver {
    @Override
    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
        log.info("call resolver", ex);
        try {
            if (ex instanceof IllegalArgumentException) {
                // 여기서 500 에러를 먹어버리고 400으로 바꾸는 것임
                log.info("IllegalArgumentException resolver to 400");
                response.sendError(HttpServletResponse.SC_BAD_REQUEST, ex.getMessage()); // 서블릿 컨테이너로 가면 400 에러로 인식함
                return new ModelAndView(); //새로운 ModelAndView 를 반환해서 WAS 까지 정상흐름으로 전달됨.
            }
        } catch (IOException e) {
            log.error("resolver ex", e);
        }
        return null; // null 을 반환하면, 다음 ExceptionResolver 를 찾아서 실행
        //ExceptionResolver 가 없으면 예외 처리가 안되고, 기존에 발생한 예외를 서블릿 밖으로 던진다.
    }
}
