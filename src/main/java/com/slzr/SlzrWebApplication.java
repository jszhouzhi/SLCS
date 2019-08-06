package com.slzr;

import com.bstek.ureport.console.UReportServlet;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ImportResource;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.resource.ContentVersionStrategy;
import org.springframework.web.servlet.resource.ResourceUrlEncodingFilter;
import org.springframework.web.servlet.resource.VersionResourceResolver;



@EnableTransactionManagement
@ServletComponentScan
@MapperScan("com.slzr.*.dao")
@SpringBootApplication
@ImportResource("classpath:UReport/context.xml")
public class SlzrWebApplication extends WebMvcConfigurerAdapter {
    public static void main(String[] args) {
        SpringApplication.run(SlzrWebApplication.class, args);
        System.out.println("---------启动成功---------");
    }

    @Bean
    public ServletRegistrationBean buildUReportServlet(){
        return new ServletRegistrationBean(new UReportServlet(),"/ureport/*");
    }
    
    
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
    	VersionResourceResolver versionResourceResolver = new VersionResourceResolver()
    	        .addVersionStrategy(new ContentVersionStrategy(), "/**");
    	registry.addResourceHandler("/**/*.js", "/**/*.css", "/**/*.png", "/**/*.jpg", "/**/*.gif", "/**/*.woff", "/**/*.woff2", "/**/*.ttf")
    	        .addResourceLocations("classpath:/static/")
    	        .setCachePeriod(60 * 60 * 24 * 365) /* one year */
    	        .resourceChain(true)
    	        .addResolver(versionResourceResolver);
    	    super.addResourceHandlers(registry);
    }
    @Bean
    public ResourceUrlEncodingFilter resourceUrlEncodingFilter() {
      return new ResourceUrlEncodingFilter();
    }

}
