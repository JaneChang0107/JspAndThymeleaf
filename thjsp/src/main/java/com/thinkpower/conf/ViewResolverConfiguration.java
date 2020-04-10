package com.thinkpower.conf;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.thymeleaf.spring5.SpringTemplateEngine;//此处及下面两行如果报错，就是”spring5“版本不对，你可以点击进去查看实际版本然后修改
import org.thymeleaf.spring5.templateresolver.SpringResourceTemplateResolver;
import org.thymeleaf.spring5.view.ThymeleafViewResolver;
import org.thymeleaf.templateresolver.ITemplateResolver;
/** 
 * 主要配置多視邱實現的視圖解析器相關bean實例 ，將該視圖解析器注冊到容器中，
 * 其實關鍵在於兩個：
 * 1、配置order屬性：視圖解析優先等級問題(就是決定先載用哪個解析器來解析視圖
 * 2、配置viewnamas屬性(配置對應的視圖析所器解析哪些格式的視圖)
 */
@Configuration 
@EnableWebMvc
@ComponentScan
public class ViewResolverConfiguration  extends WebMvcConfigurationSupport { 

        //jsp頁面的view解析器，解析到webapp下的jsp/目錄下查找對應的jsp頁面
        @Bean
     //   public ViewResolver viewResolver() {
        public InternalResourceViewResolver viewResolver() { 
            InternalResourceViewResolver resolver = new InternalResourceViewResolver();
          //不在此加上jsp檔案所在資料目錄，而在controller回傳值才加上檔案所在目錄 
            resolver.setPrefix("/WEB-INF/");
            resolver.setSuffix(".jsp");
            // 這裡是設置該view解析器所要的匹配哪些格式的view "*"代表匹配所有格式
            // setViewNames未設定時預設都會讀取jsp網頁，但有設定值只會解析設定目錄的網頁
            resolver.setViewNames(new String[] {"jsp/*"});   
            // 優先等級，spring配置多個view解析器，數字越小，優先等級越高，越先匹配
            resolver.setOrder(1);
            return resolver;
        }
        /**
         * 下面都是配置thymeleaf的view解析器相關的內容
         * 對thymeleaf的view解析器，解析到webapp下的view目錄下查找對應的頁面
         *  
         * @return
         */
        @Bean
        public ITemplateResolver templateResolver() {
            SpringResourceTemplateResolver templateResolver = new SpringResourceTemplateResolver();
            templateResolver.setTemplateMode("HTML");
            templateResolver.setPrefix("/WEB-INF/");
            templateResolver.setSuffix(".html");
            templateResolver.setCharacterEncoding("utf-8");
            templateResolver.setCacheable(false);
            return templateResolver;
        }
        @Bean
        public SpringTemplateEngine templateEngine() {
            SpringTemplateEngine templateEngine = new SpringTemplateEngine();
            templateEngine.setTemplateResolver(templateResolver());
            // templateEngine
            return templateEngine;
        }
        @Bean
        public ThymeleafViewResolver viewResolverThymeLeaf() {
            ThymeleafViewResolver viewResolver = new ThymeleafViewResolver();
            viewResolver.setTemplateEngine(templateEngine());
            viewResolver.setCharacterEncoding("utf-8");
            viewResolver.setOrder(2);//設置該視圖解析器優先等級為1
            //下面是設置該view解析器所要匹配哪格式的view "html/*", "vue/*","jsps/*","templates/*"代表匹配"html/*", "vue/*","jsps/*","templates/*"            
            viewResolver.setViewNames(new String[]{"html/*", "vue/*","templates/*","th/*","ths/*"});
            return viewResolver;
        }
        @Override
        public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
            configurer.enable();
        }

        /**         
         * 配置資源路徑
         * @param registry
         */
//        @Override
//        public void addResourceHandlers(ResourceHandlerRegistry registry) {
//            registry.addResourceHandler("/img/**").addResourceLocations("/img/");
//            registry.addResourceHandler("/static/**").addResourceLocations("/WEB-INF/" + "/static/");
//        }
   
        //redirect:index

}