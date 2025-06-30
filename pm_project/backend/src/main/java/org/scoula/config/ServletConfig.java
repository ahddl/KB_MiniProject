package org.scoula.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.support.StandardServletMultipartResolver;
import org.springframework.web.servlet.config.annotation.*;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

@EnableWebMvc
@ComponentScan(basePackages = {
        "org.scoula.exception",
        "org.scoula.controller",
        "org.scoula.board.controller"
})
public class ServletConfig implements WebMvcConfigurer {

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/")
                .setViewName("forward:/resources/index.html");

    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        //기본 리소스 핸들러
        registry
                .addResourceHandler("/resources/**")     // url이 /resources/로 시작하는 모든 경로
                .addResourceLocations("/resources/");    // webapp/resources/경로로 매핑

        // 프론트엔드 assets 핸들러
        registry.addResourceHandler("/assets/**")
                .addResourceLocations("/resources/assets/");  // --> 프론트엔드 정적 파일

        // Swagger UI 리소스 핸들러
        // API 문서 접근을 위해 필요함
        registry.addResourceHandler("/swagger-ui.html")
                .addResourceLocations("classpath:/META-INF/resources/");

        registry.addResourceHandler("/webjars/**")
                .addResourceLocations("classpath:/META-INF/resources/webjars/");

        registry.addResourceHandler("/swagger-resources/**")
                .addResourceLocations("classpath:/META-INF/resources/");

        registry.addResourceHandler("/v2/api-docs")
                .addResourceLocations("classpath:/META-INF/resources/");
    }

//    // jsp view resolver 설정
//    @Override
//    public void configureViewResolvers(ViewResolverRegistry registry) {
//        InternalResourceViewResolver bean = new InternalResourceViewResolver();
//
//        bean.setViewClass(JstlView.class);
//        bean.setPrefix("/WEB-INF/views/");
//        bean.setSuffix(".jsp");
//
//        registry.viewResolver(bean);
//    }  --> JSP를 사용 안하기 때문에 삭제

    //	Servlet 3.0 파일 업로드 사용시
    @Bean
    public MultipartResolver multipartResolver() {
        StandardServletMultipartResolver resolver = new StandardServletMultipartResolver();
        return resolver;
    }


}
