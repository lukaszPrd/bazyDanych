package studia.bazy.danych.logistyka.application;


import org.springframework.web.context.request.RequestContextListener;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.multipart.support.MultipartFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;
import studia.bazy.danych.logistyka.application.root.RootConfiguration;
import studia.bazy.danych.logistyka.application.servlet.ServletConfiguration;

import javax.servlet.Filter;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import java.util.EventListener;
import java.util.List;

import static com.google.common.collect.Lists.newArrayList;

public class MainWebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

    @Override
    public Class<?>[] getRootConfigClasses() {
        return new Class[]{RootConfiguration.class};
    }

    @Override
    public Class<?>[] getServletConfigClasses() {
        return new Class[]{ServletConfiguration.class};
    }

    @Override
    public String[] getServletMappings() {
        return new String[]{"/*"};
    }

    @Override
    public Filter[] getServletFilters() {
        return new Filter[]{new MultipartFilter(), new CharacterEncodingFilter("UTF-8")};
    }

    public List<Class<? extends EventListener>> getListeners(){
        return newArrayList(RequestContextListener.class);
    }

    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        if (servletContext.getServletRegistration(this.getServletName()) == null) {
            super.onStartup(servletContext);
            getListeners().forEach(l -> servletContext.addListener(l));
        }
    }
}