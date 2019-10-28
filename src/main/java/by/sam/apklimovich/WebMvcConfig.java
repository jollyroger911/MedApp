package by.sam.apklimovich;


import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@Configuration
@ComponentScan(basePackages = {"by.sam.apklimovich"})
public class WebMvcConfig implements WebMvcConfigurer {

}