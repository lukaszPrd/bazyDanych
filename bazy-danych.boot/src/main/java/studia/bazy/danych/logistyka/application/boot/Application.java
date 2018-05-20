package studia.bazy.danych.logistyka.application.boot;

import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.boot.Banner;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceTransactionManagerAutoConfiguration;
import org.springframework.boot.autoconfigure.web.DispatcherServletAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.DispatcherServlet;
import studia.bazy.danych.logistyka.application.MainWebAppInitializer;

import javax.servlet.Filter;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import java.util.Arrays;
import java.util.EventListener;
import java.util.LinkedList;
import java.util.List;


@SpringBootApplication
@EnableAutoConfiguration(exclude = {
        DataSourceAutoConfiguration.class,
        DataSourceTransactionManagerAutoConfiguration.class
})
public class Application extends SpringBootServletInitializer implements BeanFactoryPostProcessor {
    private static MainWebAppInitializer webAppInitializer = new MainWebAppInitializer();
    @Autowired
    private ApplicationContext ctx;
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return configureApplication(builder);
    }

    public static void main(String[] args) {
        configureApplication(new SpringApplicationBuilder()).run(args);
    }

    private static SpringApplicationBuilder configureApplication(SpringApplicationBuilder builder) {
        List<Class> sources = new LinkedList<>();
        sources.add(Application.class);
        sources.addAll(Arrays.asList(webAppInitializer.getRootConfigClasses()));
        sources.addAll(Arrays.asList(webAppInitializer.getServletConfigClasses()));
        return builder.sources(sources.toArray()).bannerMode(Banner.Mode.OFF);
    }

    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        super.onStartup(servletContext);
        webAppInitializer.getListeners().forEach(l -> servletContext.addListener(l));
    }

    @Override
    @SneakyThrows
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) {
        for(Class<? extends EventListener> listenerClass : webAppInitializer.getListeners()){
            register((BeanDefinitionRegistry) beanFactory, listenerClass);
        }
        for(Filter f : webAppInitializer.getServletFilters()){
            beanFactory.registerSingleton(f.getClass().getSimpleName(), f);
        }
    }

    private void register(BeanDefinitionRegistry register, Class<? extends EventListener> clazz) {
        register.registerBeanDefinition(clazz.getSimpleName(),
                BeanDefinitionBuilder.genericBeanDefinition(clazz).getBeanDefinition());
    }

    @Bean
    public DispatcherServlet dispatcherServlet() {
        return new DispatcherServlet();
    }

    @Bean
    public ServletRegistrationBean dispatchServletRegistration() {

        ServletRegistrationBean registration = new ServletRegistrationBean(
                dispatcherServlet(), webAppInitializer.getServletMappings());

        registration
                .setName(DispatcherServletAutoConfiguration.DEFAULT_DISPATCHER_SERVLET_REGISTRATION_BEAN_NAME);

        return registration;

    }

}
