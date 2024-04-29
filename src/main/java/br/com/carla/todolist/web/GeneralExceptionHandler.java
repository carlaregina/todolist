package br.com.carla.todolist.web;

import br.com.carla.todolist.exception.BadRequestException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

public class GeneralExceptionHandler {

    @ExceptionHandler(BadRequestException.class)
    private ResponseEntity<Object> handleBadRequest(BadRequestException exception) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(exception.getMessage());
    }
}
