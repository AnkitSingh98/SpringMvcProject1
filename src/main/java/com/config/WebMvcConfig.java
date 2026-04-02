package com.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.validation.Validator;

/*

This class is replacement for app-servlet.xml  (here app is dispatcher servlet name)
And used to configure ViewResolver and other Spring mvc beans

app-servlet.xml code:
<beans>
    <context:component-scan base-package="com.controllers"></context:component-scan>
    <mvc:annotation-driven enable-matrix-variables="true" />

    <bean id="viewResolver" class = "org.springframework.web.servlet.view.InternalResourceViewResolver">
        <property name="prefix" value="/WEB-INF/pages/" />
        <property name="suffix" value=".jsp" />
    </bean>

</beans>

 */

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.controllers")
public class WebMvcConfig implements WebMvcConfigurer {

    @Override
    public void configureViewResolvers(ViewResolverRegistry registry) {
        registry.jsp("/WEB-INF/pages/", ".jsp");
    }

    @Bean
    public LocalValidatorFactoryBean validator() {
        return new LocalValidatorFactoryBean();
    }

    @Override
    public Validator getValidator() {
        return validator();
    }

}
