//package com.example.Ecom.global;
//
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.MethodArgumentNotValidException;
//import org.springframework.web.bind.annotation.ExceptionHandler;
//import org.springframework.web.bind.annotation.RestControllerAdvice;
//import org.springframework.web.context.request.WebRequest;
//
//import java.time.LocalDateTime;
//import java.util.HashMap;
//import java.util.Map;
//
//@RestControllerAdvice
//public class GlobalExceptionHandler {
//
//    // 🔴 400 - Validation errors
//    @ExceptionHandler(MethodArgumentNotValidException.class)
//    public ResponseEntity<Map<String, Object>> handleValidationException(
//            MethodArgumentNotValidException ex) {
//
//        Map<String, String> fieldErrors = new HashMap<>();
//        ex.getBindingResult().getFieldErrors()
//                .forEach(error ->
//                        fieldErrors.put(error.getField(), error.getDefaultMessage()));
//
//        Map<String, Object> response = new HashMap<>();
//        response.put("timestamp", LocalDateTime.now());
//        response.put("status", 400);
//        response.put("error", "Validation Failed");
//        response.put("errors", fieldErrors);
//
//        return ResponseEntity.badRequest().body(response);
//    }
//
//    // 🔴 404 - Resource not found
//    @ExceptionHandler(RuntimeException.class)
//    public ResponseEntity<Map<String, Object>> handleNotFoundException(
//            RuntimeException ex, WebRequest request) {
//
//        Map<String, Object> response = new HashMap<>();
//        response.put("timestamp", LocalDateTime.now());
//        response.put("status", 404);
//        response.put("error", "Not Found");
//        response.put("message", ex.getMessage());
//        response.put("path", request.getDescription(false));
//
//        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
//    }
//
//    // 🔴 500 - Everything else
//    @ExceptionHandler(Exception.class)
//    public ResponseEntity<Map<String, Object>> handleGlobalException(
//            Exception ex, WebRequest request) {
//
//        Map<String, Object> response = new HashMap<>();
//        response.put("timestamp", LocalDateTime.now());
//        response.put("status", 500);
//        response.put("error", "Internal Server Error");
//        response.put("message", ex.getMessage());
//        response.put("path", request.getDescription(false));
//
//        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
//    }
//}
