package hello.typeconverter.type;

import lombok.EqualsAndHashCode;
import lombok.Getter;

/**
 * 사용자 정의 타입 컨버터
 * ex) 127.0.0.1:8080 처럼 들어오면 IpPort 객체로 변환하기 위함
 */
@Getter
@EqualsAndHashCode
public class IpPort {
    private String ip;
    private int port;

    public IpPort(String ip, int port) {
        this.ip = ip;
        this.port = port;
    }
}
