package com.obse.military.course.models.interfaces;

import com.obse.military.course.models.Product;

import java.util.List;
import java.util.Map;

/**
 * Интерфейс Склада Продуктов
 */
public interface ProductStorageI {
    /**
     * Метод добавления продукта на склад
     */
    boolean add(Product product);

    /**
     * Метод удаления продукта со склада
     */
    boolean remove(Product product);

    /**
     * Метод Получения всех продуктов на текщий момент
     */
    Map<String, List<Product>> getProducts();
}
