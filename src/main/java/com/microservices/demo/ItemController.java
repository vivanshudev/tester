package com.microservices.demo;

import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ItemController {

    @GetMapping("/get")
    public String get() {
        return "Hello World from Vivanshu!!";
    }

    @GetMapping("/notFound")
    public ResponseEntity<ErrorResponse> errorEvent() {
        ErrorResponse errorResponse = new ErrorResponse("Error World from Vivanshu!!", "CUSTOM_ERROR_CODE", "Additional error details");
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorResponse);
    }

    @Getter
    public static class ErrorResponse {
        private final String message;
        private final String errorCode;
        private final String errorDetails;

        public ErrorResponse(String message, String errorCode, String errorDetails) {
            this.message = message;
            this.errorCode = errorCode;
            this.errorDetails = errorDetails;
        }

    }
}
