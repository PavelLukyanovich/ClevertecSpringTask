package ru.clevertec.ecl.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import ru.clevertec.ecl.exception.CertificateJsonParseException;
import ru.clevertec.ecl.exception.NoSuchElementsException;
import ru.clevertec.ecl.model.ErrorResponse;

@RestControllerAdvice
public class CertificateExceptionHandler {
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(NoSuchElementsException.class)
    public ErrorResponse handlerNoSuchElementsException(NoSuchElementsException e) {

        return new ErrorResponse(HttpStatus.NOT_FOUND, "Certificate with current ids not founded " + e.getNotFoundGiftCertificate().getId(),
                HttpStatus.NOT_FOUND.toString() + e.getNotFoundGiftCertificate().getId());
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(CertificateJsonParseException.class)
    public ErrorResponse handlerNoSuchElementsException(CertificateJsonParseException e) {

        return new ErrorResponse(HttpStatus.BAD_REQUEST, "Something went wrong, pls try again", HttpStatus.BAD_REQUEST + e.getMessage());
    }
}
