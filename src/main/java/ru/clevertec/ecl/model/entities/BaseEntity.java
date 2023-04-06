package ru.clevertec.ecl.model.entities;

import java.io.Serializable;

public interface BaseEntity<K> extends Serializable {

    K getId();
}
