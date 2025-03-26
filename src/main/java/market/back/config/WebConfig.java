package market.back.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@Slf4j
public class WebConfig implements WebMvcConfigurer {
    @Value("${spring.front.url}")
    private String frontUrl;

    @Override
    public void addCorsMappings(CorsRegistry registry) {

        log.info("front url: {}", frontUrl);
        registry.addMapping("/**")
                .allowedOrigins(frontUrl)
                .allowedMethods("*")
                .allowedHeaders("*")
                .exposedHeaders("Authorization")
                .allowCredentials(true)
                .maxAge(3000);
    }
}
