package io.github.lamprose.bookshell.config;

import io.github.lamprose.bookshell.interceptor.Interceptor;
import io.github.lamprose.bookshell.interceptor.LogInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.*;

@Configuration
public class Config implements WebMvcConfigurer {
    /**
     * 解决前后端跨域问题
     * @author lhy
     * @create 2018-05-27-18:06
     * 什么是同一个域？
     * 同一协议，同一ip，同一端口，三同中有一不同就产生了跨域。
     **/
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("*")
                .allowCredentials(true)
                .allowedMethods("GET", "POST", "DELETE", "PUT")
                .allowedHeaders("*")
                .exposedHeaders("Token")
                .maxAge(3600);
    }
    //使用WebMvcConfigurerAdapter可以来扩展SpringMVC的功能
    //@EnableWebMvc   不要接管SpringMVC
    @Bean
    public HandlerInterceptor getInterceptor(){
        return new Interceptor();
    }

    //注册拦截器2
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
         /*addPathPatterns 用于添加拦截规则
         excludePathPatterns 用户排除拦截*/
        registry.addInterceptor(getInterceptor()).addPathPatterns("/**")
                .excludePathPatterns("/user/register", "/", "/user/login","/UserAvatar/**","/user/getInfo",
                        "/user/check","/security/**","/cars/getCarInfo","/Shops/**","/evaluation/getEvaluationListPage",
                        "/admin/getShopInfo","/cars/searchByText","/cars/getHotSearch","/cars/queryStringByText",
                        "/admin/getEachShopTopNumberCars","");
        registry.addInterceptor(new LogInterceptor()).addPathPatterns("/**");
    }

}
