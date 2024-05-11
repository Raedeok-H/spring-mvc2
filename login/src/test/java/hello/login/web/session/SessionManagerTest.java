package hello.login.web.session;

import hello.login.domain.member.Member;
import org.junit.jupiter.api.Test;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;

import static org.assertj.core.api.Assertions.assertThat;

class SessionManagerTest {

    SessionManager sessionManager = new SessionManager();

    @Test
    void sessionTest() {
        //MockHttpServletResponse
        //MockHttpServletRequest
        // 테스트에서 HttpServletResponse, HttpServletRequest 를 사용할 수 없기 때문에,
        // 가짜 객체를 사용했다.

        // 세션 생성(서버 -> 클라이언트의 상황을 가정)
        MockHttpServletResponse response = new MockHttpServletResponse();
        Member member = new Member();
        sessionManager.createSession(member, response);

        //요청에 응답 쿠키 저장(클라이언트 -> 서버의 상황을 가정)
        MockHttpServletRequest request = new MockHttpServletRequest();
        request.setCookies(response.getCookies()); // mySessionId=1298hfaisodlhf

        //세션 조회(서버에서 받은 요청에서의 쿠키를 조회)
        Object result = sessionManager.getSession(request);
        assertThat(result).isEqualTo(member);

        //세션 만료(서버에서 요청의 쿠키를 만료시키고 조회해서 확인해 봄)
        sessionManager.expire(request);
        Object expired = sessionManager.getSession(request);
        assertThat(expired).isNull();
    }
}