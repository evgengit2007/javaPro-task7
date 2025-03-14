package ru.vtb.javaPro.mapstructure;

public interface MapRequestBody<F,T> {

    T mapper(F requestBody);
}
