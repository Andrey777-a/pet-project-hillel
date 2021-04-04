package com.example.springhillel.api;

import com.example.springhillel.exception.AbstractException;
import com.example.springhillel.exception.EntityExistsException;
import com.example.springhillel.exception.NotFoundException;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.*;
import java.util.stream.Collectors;

@ControllerAdvice
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = {EntityExistsException.class})
    protected ResponseEntity<Object> handleConflict(AbstractException ex, WebRequest request) {

        Map<String, Object> body = getResponseMap(
                ex.getMessage(), ex.getMessageCode());

        return new ResponseEntity<>(body, new HttpHeaders(), HttpStatus.CONFLICT);
    }

    @ExceptionHandler(value = NotFoundException.class)
    protected ResponseEntity<Object> handleNotFound(AbstractException ex, WebRequest request) {

        Map<String, Object> body = getResponseMap(HttpStatus.NOT_FOUND,
                new ArrayList<>(Collections.singletonList(ex.getMessage())));

        return new ResponseEntity<>(body, new HttpHeaders(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(value = {Exception.class})
    protected ResponseEntity<Object> handleAllExceptions(Exception ex, WebRequest request) {
        for (int i = 0; i < ex.getStackTrace().length; i++) {
            System.out.println(ex.getStackTrace()[i].toString());
        }
        Map<String, Object> body = new LinkedHashMap<>();
        body.put("timestamp", new Date());
        body.put("message", ex.getMessage());
        body.put("errors", Arrays.stream(ex.getStackTrace()).map(StackTraceElement::toString));

        return new ResponseEntity<>(body, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
    }


    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
                                                                  HttpHeaders headers,
                                                                  HttpStatus status, WebRequest request) {

        List<String> errors = ex.getBindingResult()
                .getFieldErrors()
                .stream()
                .map(DefaultMessageSourceResolvable::getDefaultMessage)
                .collect(Collectors.toList());

        Map<String, Object> body = getResponseMap(status, errors);

        return new ResponseEntity<>(body, headers, status);
    }

    private Map<String, Object> getResponseMap(HttpStatus status, List<String> errors) {
        Map<String, Object> body = new LinkedHashMap<>();
        body.put("timestamp", new Date());
        body.put("status", status.toString());
        body.put("errors", errors);
        return body;
    }

    private Map<String, Object> getResponseMap(String errors, String errorCode) {
        Map<String, Object> body = new LinkedHashMap<>();
        body.put("timestamp", new Date());
        body.put("status", HttpStatus.CONFLICT.toString());
        body.put("errors", errors);
        body.put("errorCode", errorCode);
        return body;
    }

}
