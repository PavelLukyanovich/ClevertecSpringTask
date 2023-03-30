package ru.clevertec.ecl.model;

import org.springframework.http.HttpStatus;

public record ErrorResponse(HttpStatus httpStatus, String errorMessage, String errorStatus) {
}
