package ma.yc.marjane.exception;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jdk.jshell.spi.ExecutionControl;
import ma.yc.marjane.dto.CustomErrorResponse;
import ma.yc.marjane.dto.ErrorResponse;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.client.HttpClientErrorException;

import java.io.IOException;
import java.util.Arrays;

//@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = {
            Exception.class,
    })
    public ResponseEntity<ErrorResponse > defaultErrorHandler(HttpServletRequest req, Exception e) throws Exception {
        if (AnnotationUtils.findAnnotation(e.getClass(), ResponseStatus.class) != null)
            throw e;

        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setException(e.getClass().getSimpleName());
        errorResponse.setMessage(e.getMessage());
        errorResponse.setUrl(req.getRequestURL().toString());

        return new ResponseEntity<>(errorResponse , HttpStatus.INTERNAL_SERVER_ERROR) ;
    }

    @ExceptionHandler(value = {
            ResourceNotFoundException.class,
    })
        public ResponseEntity<ErrorResponse> resourceNotFoundException(HttpServletRequest req, Exception e) throws Exception {
        if (AnnotationUtils.findAnnotation(e.getClass(), ResponseStatus.class) != null)
            throw e;

        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setException(e.getClass().getSimpleName());
        errorResponse.setMessage(e.getMessage());
        errorResponse.setUrl(req.getRequestURL().toString());
        errorResponse.setStatus(HttpStatus.BAD_REQUEST);

        return new ResponseEntity<>(errorResponse , HttpStatus.BAD_REQUEST) ;
    }

    @ExceptionHandler(value= {
            HttpClientErrorException.NotFound.class,
            ServletException.class,
            ChangeSetPersister.NotFoundException.class,
            IOException.class
    })
    public ResponseEntity<ErrorResponse> badRequestExecption(HttpServletRequest req, Exception e) throws Exception {
        if (AnnotationUtils.findAnnotation(e.getClass(), ResponseStatus.class) != null)
            throw e;

        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setException(e.getClass().getSimpleName());
        errorResponse.setMessage(e.getMessage());
        errorResponse.setUrl(req.getRequestURL().toString());
        errorResponse.setStatus(HttpStatus.NOT_FOUND);

        return new ResponseEntity<>(errorResponse , HttpStatus.NOT_FOUND) ;
    }
    @ExceptionHandler(value =
            {
                    org.springframework.web.servlet.NoHandlerFoundException.class
            }
    )
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<ErrorResponse> noHandlerFoundException(Exception e) {
        ErrorResponse error = new ErrorResponse();
        error.setStatus(HttpStatus.NOT_FOUND);
        error.setMessage("The requested resource was not found");
        error.setException(e.getClass().getSimpleName());
        error.setUrl(Arrays.toString(e.getStackTrace()));
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }




}