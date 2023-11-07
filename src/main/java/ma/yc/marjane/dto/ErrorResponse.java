package ma.yc.marjane.dto;

public  class ErrorResponse extends RuntimeException {
        private String message;
        private String details;

        public ErrorResponse(String message, String details) {
            this.message = message;
            this.details = details;
        }

        // Getters and setters for message and details
    }