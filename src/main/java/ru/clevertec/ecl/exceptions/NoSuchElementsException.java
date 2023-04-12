package ru.clevertec.ecl.exceptions;

import lombok.Getter;

@Getter
public class NoSuchElementsException extends RuntimeException {

    Long id;

    public NoSuchElementsException(Long id) {
        this.id = id;
    }
}
