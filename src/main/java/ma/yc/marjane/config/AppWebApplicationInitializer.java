package ma.yc.marjane.config;

import jakarta.servlet.Filter;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRegistration;
import org.springframework.context.ApplicationContext;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.filter.HiddenHttpMethodFilter;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class AppWebApplicationInitializer implements WebApplicationInitializer {
  //  @Override
//    protected Class<?>[] getRootConfigClasses() {
//        return new Class[]{BasicDataSourceCfg.class, TransactionCfg.class};
//    }
//
//    @Override
//    protected Class<?>[] getServletConfigClasses() {
//        return new Class[]{AppConfig.class};
//    }
//
//    @Override
//    protected String[] getServletMappings() {
//        return new String[]{"/*"};
//    }
//
//    @Override
//    protected Filter[] getServletFilters() {
//        final CharacterEncodingFilter cef = new CharacterEncodingFilter();
//        cef.setEncoding("UTF-8");
//        cef.setForceEncoding(true);
//        return new Filter[]{new HiddenHttpMethodFilter(), cef};
//    }


    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {

        AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();
        context.register(AppConfig.class);

        DispatcherServlet servlet = new DispatcherServlet(context);
        ServletRegistration.Dynamic registration = servletContext.addServlet("app", servlet);
        registration.setLoadOnStartup(1);
        registration.addMapping("/");

    }


}
