package ru.clevertec.ecl.exception;

import lombok.Getter;
import ru.clevertec.ecl.model.entities.GiftCertificate;

@Getter
public class NoSuchElementsException extends RuntimeException {

    private final GiftCertificate notFoundGiftCertificate;

    public NoSuchElementsException(GiftCertificate notFoundGiftCertificate) {
        this.notFoundGiftCertificate = notFoundGiftCertificate;
    }
}
