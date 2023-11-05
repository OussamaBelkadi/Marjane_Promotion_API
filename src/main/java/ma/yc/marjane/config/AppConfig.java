package ma.yc.marjane.config;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.servlet.ServletException;
import ma.yc.marjane.dto.ErrorResponse;
import ma.yc.marjane.exception.ApplicationExceptionHandler;
import org.hibernate.engine.jdbc.spi.SqlExceptionHelper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.sql.SQLException;
import java.util.List;

@Configuration
@ComponentScan(basePackages = {"ma.yc.marjane"})
@EnableWebMvc
@EnableJpaRepositories(basePackages = {"ma.yc.marjane.repository"})
public class AppConfig  implements WebMvcConfigurer {

    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        converters.add(new org.springframework.http.converter.json.MappingJackson2HttpMessageConverter());
    }



    @Override
    public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {
        configurer.defaultContentType(MediaType.APPLICATION_JSON);

    }

    @Bean
    EntityManagerFactory entityManagerFactory(){
        return Persistence.createEntityManagerFactory("default");
    }

    @Bean
    EntityManager entityManager(EntityManagerFactory entityManagerFactory){
        return entityManagerFactory.createEntityManager();
    }

    @Bean
    public PlatformTransactionManager transactionManager(EntityManagerFactory entityManagerFactory) {
        JpaTransactionManager txManager = new JpaTransactionManager();
        txManager.setEntityManagerFactory(entityManagerFactory);
        return txManager;
    }



//    @ExceptionHandler(ServletException.class)
//    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
//    public ResponseEntity<ErrorResponse> handleServletException(ServletException ex) {
//        ErrorResponse errorResponse = new ErrorResponse("An error occurred", ex.getMessage());
//        return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
//    }


//    @ExceptionHandler(Exception.class)
    public String handleException(Exception ex){
        System.out.println("this is the exception handler is called");
        System.out.println("ex = " + ex);
        return ex.getMessage();
    }

//    @ExceptionHandler(RuntimeException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResponseEntity<ErrorResponse> handleRuntimeException(RuntimeException ex) {
        ErrorResponse errorResponse = new ErrorResponse("An error occurred", ex.getMessage());
        return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(SQLException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResponseEntity<ErrorResponse> handleSqlExceptionHelper(SQLException ex) {
        ErrorResponse errorResponse = new ErrorResponse("An error occurred", ex.getMessage());
        return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }


}
