package hello.typeconverter;

import hello.typeconverter.converter.IntegerToStringConverter;
import hello.typeconverter.converter.IpPortToStringConverter;
import hello.typeconverter.converter.StringToIntegerConverter;
import hello.typeconverter.converter.StringToIpPortConverter;
import hello.typeconverter.formatter.MyNumberFormatter;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {
    /**
     * 스프링은 내부에서 ConversionService 를 제공한다.
     * 우리는 WebMvcConfigurer 가 제공하는 addFormatters() 를 사용해서 추가하고 싶은 컨버터를 등록하면 된다.
     * 이렇게 하면 스프링은 내부에서 사용하는 ConversionService 에 컨버터를 추가해준다.
     */
     @Override
     public void addFormatters(FormatterRegistry registry) {
         // 우선 순위때문에 주석처리
//         registry.addConverter(new StringToIntegerConverter());
//         registry.addConverter(new IntegerToStringConverter());
         registry.addConverter(new StringToIpPortConverter());
         registry.addConverter(new IpPortToStringConverter());

         // 추가
         registry.addFormatter(new MyNumberFormatter());
     }
     // 그런데 생각해보면 StringToIntegerConverter 를 등록하기 전에도 이 코드는 잘 수행되었다.
     // 그것은 스프링이 내부에서 수 많은 기본 컨버터들을 제공하기 때문이다.
     // 컨버터를 추가하면 추가한 컨버터가 기본 컨버터 보다 높은 우선 순위를 가진다
}
