package ru.clevertec.ecl.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import ru.clevertec.ecl.exception.JsonParseException;
import ru.clevertec.ecl.exception.NoSuchElementsException;
import ru.clevertec.ecl.model.ErrorResponse;

@RestControllerAdvice
public class ApplicationExceptionHandler {
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(NoSuchElementsException.class)
    public ErrorResponse handlerNoSuchElementsException(NoSuchElementsException e) {

        return new ErrorResponse(HttpStatus.NOT_FOUND, "Certificate with current ids not founded " + "ID = " + e.getBaseEntity().getId(),
                String.valueOf(HttpStatus.NOT_FOUND.value()) + e.getBaseEntity().getId());
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(JsonParseException.class)
    public ErrorResponse handlerJsonParseException(JsonParseException e) {

        return new ErrorResponse(HttpStatus.BAD_REQUEST, "JSON is not correct", HttpStatus.BAD_REQUEST.toString());
    }
}
