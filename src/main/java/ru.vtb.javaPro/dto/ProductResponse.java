package ru.vtb.javaPro.dto;

import ru.vtb.javaPro.entity.Product;

import java.util.List;

public record ProductResponse(List<Product> productList) {
}
