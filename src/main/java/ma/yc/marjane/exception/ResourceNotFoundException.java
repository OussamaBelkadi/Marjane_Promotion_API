package ma.yc.marjane.exception;

public class ResourceNotFoundException extends RuntimeException{
    public ResourceNotFoundException(String message){
        super(message.toUpperCase())
;    }
}
