package ma.yc.marjane.exception;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.HashMap;
import java.util.Map;

//@ControllerAdvice
public class ApplicationExceptionHandler {


    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String ,String> handleValidationExceptions(MethodArgumentNotValidException ex){
        Map<String,String> map = new HashMap<>();
        ex.getBindingResult().getFieldErrors().forEach(fieldError -> {
            map.put(fieldError.getField(),fieldError.getDefaultMessage());
        });

        return  map;
    }

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler({
            Exception.class,
            RuntimeException.class,
            Throwable.class
    })
    public String handleException(Exception ex){
        System.out.println("this is the exception handler is called");
        System.out.println("ex = " + ex);
        return ex.getMessage();
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(IllegalArgumentException.class)
    public String handleIllegalArgumentException(IllegalArgumentException ex){
        System.out.println("this is the exception handler is called");
        System.out.println("ex = " + ex);
        return ex.getMessage();
    }

    @ExceptionHandler(ServletException.class)
    public String handleServletException(ServletException ex){
        System.out.println("this is the exception handler is called");
        System.out.println("ex = " + ex);
        return ex.getMessage();
    }




}
