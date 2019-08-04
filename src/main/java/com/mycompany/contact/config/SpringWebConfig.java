
package com.mycompany.contact.config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

@Configuration
@ComponentScan(basePackages = {"com.mycompany"})
@EnableWebMvc
public class SpringWebConfig extends WebMvcConfigurerAdapter{

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        //TODO: defining resource handler for css to connect with jsp page
        registry.addResourceHandler("/static/**").addResourceLocations("/static/");
    }
    
    @Bean 
    public ViewResolver viewResolver(){
       InternalResourceViewResolver vr = new InternalResourceViewResolver();
       vr.setViewClass(JstlView.class);
       vr.setPrefix("/WEB-INF/view/");  //never miss forward slash
       vr.setSuffix(".jsp");
       return vr;
    
         }
    }
