package ru.clevertec.ecl.exceptions;

import lombok.Getter;
import ru.clevertec.ecl.model.entities.BaseEntity;

@Getter
public class NoSuchElementsException extends RuntimeException {

    private final BaseEntity baseEntity;

    public NoSuchElementsException(BaseEntity baseEntity) {
        this.baseEntity = baseEntity;
    }
}
