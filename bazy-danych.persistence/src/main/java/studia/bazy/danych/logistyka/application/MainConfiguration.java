package studia.bazy.danych.logistyka.application;

import com.google.common.collect.Lists;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.MutablePropertySources;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePropertySource;
import org.springframework.util.StreamUtils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Properties;

@Configuration
@Order(Ordered.HIGHEST_PRECEDENCE)
public class MainConfiguration implements ApplicationContextAware {
    private static final String appMainFileName = "app.properties";
    private static final String appMainResource = "META-INF/config/" + appMainFileName;
    private static final String appConfigDirPropertyName = "application.config.dir";
    private File appConfigDir;
    private ApplicationContext context;
    private List<String> resourcesWildcards = Lists.newArrayList(
            "classpath*:/META-INF/config/*.properties",
            "classpath*:/config/*.properties"
    );

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.context = applicationContext;
        try {
            Properties properties = new Properties();
            InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream(appMainResource);
            properties.load(inputStream);
            inputStream.close();
            loadApplicationConfigDir(properties);
            extractResources(properties);
            initEnvronmentPropertySources();
        } catch (Exception e) {
            throw new RuntimeException("Unable to initialize Environment sources : " + e.getMessage(), e);
        }
    }

    private void loadApplicationConfigDir(Properties properties) throws Exception {

        appConfigDir = new File(properties.getProperty(appConfigDirPropertyName));
        if (!appConfigDir.exists() && !appConfigDir.mkdirs()) {
            throw new RuntimeException("Unable to create config dir : " + appConfigDir.getAbsolutePath());
        }
    }

    private void initEnvronmentPropertySources() throws IOException {
        ConfigurableEnvironment configurableEnvironment = (ConfigurableEnvironment) context.getEnvironment();
        MutablePropertySources propertySources = configurableEnvironment.getPropertySources();
        for (Resource resourceLocation : getResourceLocations()) {
            propertySources.addFirst(new ResourcePropertySource(resourceLocation));
        }
    }

    @Bean
    public PropertyPlaceholderConfigurer propertyPlaceholderConfigurer() throws IOException {
        PropertyPlaceholderConfigurer ppc = new PropertyPlaceholderConfigurer();
        Resource[] resourceLocations = getResourceLocations();
        ppc.setLocations(resourceLocations);
        return ppc;
    }

    protected Resource[] getResourceLocations() throws IOException {
        List<Resource> resources = new LinkedList<>();
        resources.add(new ClassPathResource(appMainResource));
        for (File resource : appConfigDir.listFiles()) {
            resources.add(new FileSystemResource(resource));
        }
        return resources.toArray(new Resource[]{});
    }

    private void extractResources(Properties properties) throws IOException {
        PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        for (String resourceWildcard : getResourcesWildcards()) {
            for (Resource resource : resolver.getResources(resourceWildcard)) {
                File destFile = new File(appConfigDir, resource.getFilename());
                if ((!destFile.exists()) && !destFile.getName().equals(appMainFileName)) {
                    FileOutputStream out = new FileOutputStream(destFile);
                    StreamUtils.copy(resource.getInputStream(), out);
                    out.close();
                }
            }
        }
    }

    protected List<String> getResourcesWildcards() {
        return Collections.unmodifiableList(resourcesWildcards);
    }


}