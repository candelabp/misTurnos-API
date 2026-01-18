package exception;

import jakarta.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
    //404
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ApiError> handleNotFound(
            ResourceNotFoundException exception,
            HttpServletRequest request
    ){
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(ApiError.of(404,"NOT_FOUND",exception.getMessage(),request));
    }

    //409
    @ExceptionHandler (BusinessConflictException.class)
    public ResponseEntity<ApiError>handleConflict(
            BusinessConflictException exception,
            HttpServletRequest request
    ){
        return ResponseEntity.status(HttpStatus.CONFLICT)
                .body(ApiError.of(409,"CONFLICT", exception.getMessage(), request));
    }

    //400
    @ExceptionHandler (BadRequestException.class)
    public ResponseEntity<ApiError> handleBadRequest(
            BadRequestException exception,
            HttpServletRequest request
    ){
        return ResponseEntity.badRequest()
                .body(ApiError.of(400,"BAD_REQUEST", exception.getMessage(), request));
    }

    //500
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiError>handleGeneric(
            Exception exception,
            HttpServletRequest request
    ){
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(ApiError.of(500,"ERROR","Error inesperado", request));
    }

}
