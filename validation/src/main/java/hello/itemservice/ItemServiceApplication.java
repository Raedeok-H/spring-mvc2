package hello.itemservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ItemServiceApplication{
	public static void main(String[] args) {
		SpringApplication.run(ItemServiceApplication.class, args);
	}
// 애노테이션 기반 빈 검증을 위해 글로벌 설정 제거
}
