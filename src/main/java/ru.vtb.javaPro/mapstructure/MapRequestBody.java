package ru.vtb.javaPro.mapstructure;

public interface MapRequestBody<F,T> {

    public T mapper(F requestBody);
}
