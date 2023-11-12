package ma.yc.marjane.dto;

public class CustomErrorResponse {
    private String errorMessage;
    private String details;

    // Constructors, getters, and setters

    public CustomErrorResponse(String errorMessage, String details) {
        this.errorMessage = errorMessage;
        this.details = details;
    }
}