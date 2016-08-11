package com.mabao.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.*;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@EnableWebMvc
@ComponentScan("com.mabao.controller")
public class WebConfig extends WebMvcConfigurerAdapter {

    @Bean
    public ViewResolver viewResolver() {
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        resolver.setPrefix("/WEB-INF/views/");
        resolver.setSuffix(".jsp");
        return resolver;
    }

    @Bean
    public CommonsMultipartResolver multipartResolver(){
        CommonsMultipartResolver commonsMultipartResolver = new CommonsMultipartResolver();
        commonsMultipartResolver.setMaxUploadSize(5048576);
        return commonsMultipartResolver;
    }

    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        super.addResourceHandlers(registry);
    }

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/login").setViewName("login");
        registry.addViewController("/res").setViewName("res");
        registry.addViewController("/developing").setViewName("developing");
        registry.addViewController("/consignment").setViewName("consignment");
        registry.addViewController("/user/shopping").setViewName("shopping");
        registry.addViewController("/user/personal").setViewName("personal");
        registry.addViewController("/user/new_address").setViewName("new_address");
        registry.addViewController("/user/consale").setViewName("consale");
        registry.addViewController("/user/selfup").setViewName("selfup");
        registry.addViewController("/user/purchase_order").setViewName("purchase_order");
        registry.addViewController("/user/unpaid_order").setViewName("unpaid_order");
        registry.addViewController("/user/nopackaged_order").setViewName("nopackaged_order");
        registry.addViewController("/user/ckeck_order").setViewName("ckeck_order");
        registry.addViewController("/user/consignment_order").setViewName("consignment_order");
        registry.addViewController("/user/finish_order").setViewName("finish_order");
        registry.addViewController("/user/published_order").setViewName("published_order");
        registry.addViewController("/user/unpublished_order").setViewName("unpublished_order");
        registry.addViewController("/user/bind_phone").setViewName("bind_phone");
        registry.addViewController("/user/consignment_success").setViewName("consignment_success");
    }
}
