package com.luxetech.backend.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import java.time.LocalDateTime;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @Data
    @AllArgsConstructor
    public static class ErrorDetail {
        private LocalDateTime timestamp;
        private int status;
        private String error;
        private String message;
        private String path;
    }

    @ExceptionHandler(InsufficientStockException.class)
    public ResponseEntity<ErrorDetail> handleStockException(InsufficientStockException ex, WebRequest request) {
        ErrorDetail error = new ErrorDetail(
            LocalDateTime.now(),
            HttpStatus.BAD_REQUEST.value(),
            "KHO_HANG_LOI",
            ex.getMessage(),
            request.getDescription(false)
        );
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ErrorDetail> handleNotFoundException(ResourceNotFoundException ex, WebRequest request) {
        ErrorDetail error = new ErrorDetail(
            LocalDateTime.now(),
            HttpStatus.NOT_FOUND.value(),
            "KHONG_TIM_THAY",
            ex.getMessage(),
            request.getDescription(false)
        );
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorDetail> handleGlobalException(Exception ex, WebRequest request) {
        ErrorDetail error = new ErrorDetail(
            LocalDateTime.now(),
            HttpStatus.INTERNAL_SERVER_ERROR.value(),
            "HE_THONG_LOI",
            "Đã có lỗi xảy ra, vui lòng thử lại sau!",
            request.getDescription(false)
        );
        return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
