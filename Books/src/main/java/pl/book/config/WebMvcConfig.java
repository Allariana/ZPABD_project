package pl.book.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.thymeleaf.spring5.SpringTemplateEngine;
import org.thymeleaf.spring5.view.ThymeleafViewResolver;
import org.thymeleaf.templateresolver.ClassLoaderTemplateResolver;

@EnableWebMvc
@Configuration
@ComponentScan (basePackages= {"pl.book.controllers"})
public class WebMvcConfig implements WebMvcConfigurer {
	
//	@Bean
//	  public ViewResolver viewResolver() {
//	    ClassLoaderTemplateResolver templateResolver = new ClassLoaderTemplateResolver();
//	    templateResolver.setTemplateMode("XHTML");
//	    templateResolver.setPrefix("templates/");
//	    templateResolver.setSuffix(".html");
//	    SpringTemplateEngine engine = new SpringTemplateEngine();
//	    engine.setTemplateResolver(templateResolver);
//
//	    ThymeleafViewResolver viewResolver = new ThymeleafViewResolver();
//	    viewResolver.setTemplateEngine(engine);
//	    return viewResolver;
//	  }

//	@Bean
//	public DriverManagerDataSource getDataSource() {
//
//		DriverManagerDataSource ds = new DriverManagerDataSource();
//		ds.setDriverClassName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
//		ds.setUrl("jdbc:sqlserver://localhost;databaseName=Books");
//		ds.setUsername("sa");
//		ds.setPassword("praktyka");
//
//		return ds;
//	}
//	@Bean
//	public InternalResourceViewResolver resolver() {
//	    InternalResourceViewResolver vr = new InternalResourceViewResolver();
//	    vr.setPrefix("/resources/templates/");
//	    vr.setSuffix(".html");
//	    return vr;
//	}
//	@Override
//    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
//        configurer.enable();
//    }

}
