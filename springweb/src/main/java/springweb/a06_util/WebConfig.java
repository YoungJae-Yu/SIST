package springweb.a06_util;

import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

@Configuration
@EnableWebMvc
public class WebConfig implements WebMvcConfigurer{
	// ResponseEntity<객체>를 리턴할 때, json데이터
	@Override
	public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
		converters.add(new MappingJackson2HttpMessageConverter());
	}
	@Bean
	public RequestMappingHandlerMapping getBean() {
		return new RequestMappingHandlerMapping();
	}
	@Bean
	public RequestMappingHandlerAdapter getBean2() {
		return new RequestMappingHandlerAdapter();
	}
	
}
