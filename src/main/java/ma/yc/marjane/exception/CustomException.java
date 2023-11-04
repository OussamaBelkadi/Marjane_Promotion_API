package ma.yc.marjane.exception;

public class CustomException extends Exception{
    private String additionalInformation;

    public CustomException(String message){
        super(message);
    }

    public CustomException(String message, String additionalInformation){
        super(message);
        this.additionalInformation = additionalInformation;
    }
    public String getAdditionalInformation(){
        return additionalInformation;
    }

}
