//package com.co.enggit.config;
//
//import jakarta.servlet.ServletContext;
//import org.springframework.web.WebApplicationInitializer;
//import org.springframework.web.context.ContextLoaderListener;
//import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
//import org.springframework.web.filter.DelegatingFilterProxy;
//
//public class AppInitializer implements WebApplicationInitializer {
//
//    @Override
//    public void onStartup(ServletContext servletContext){
//
//        AnnotationConfigWebApplicationContext root = new AnnotationConfigWebApplicationContext();
//        root.register(config.SecurityConfig.class);
//
//        servletContext.addListener(new ContextLoaderListener(root));
//
//        servletContext.addFilter("securityFilter", new DelegatingFilterProxy("springSecurityFilterChain"))
//                .addMappingForUrlPatterns(null, false, "/*");
//    }
//}
