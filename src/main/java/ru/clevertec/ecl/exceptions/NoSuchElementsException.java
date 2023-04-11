package ru.clevertec.ecl.exceptions;

import lombok.Getter;
import ru.clevertec.ecl.model.entities.BaseEntity;

@Getter
public class NoSuchElementsException extends RuntimeException {

    Long id;
    public NoSuchElementsException(Long id) {
        this.id = id;
    }
}
