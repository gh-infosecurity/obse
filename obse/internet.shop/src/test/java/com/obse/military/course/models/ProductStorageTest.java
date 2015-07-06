package com.obse.military.course.models;

import com.obse.military.course.service.ProductStorage;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@RunWith(MockitoJUnitRunner.class)
public class ProductStorageTest {
    private ProductStorage productStorage;
    private Product product;

    @Before
    public void setUp() {
        productStorage = new ProductStorage();
    }

    @Test
    public void testAddProducts() {
        product = new Product("manufacturer", "title", 0.5);

        boolean addStatus = productStorage.add(product);
        Map<String, List<Product>> actual = productStorage.getProducts();

        Map<String, List<Product>> expected = new HashMap<String, List<Product>>() {{
            put(product.getProductID(), Collections.singletonList(product));
        }};

        assertTrue(addStatus);
        assertEquals(expected, actual);
        assertEquals(1, actual.get(product.getProductID()).size());
    }

    @Test
    public void testAddSameProducts() {
        final Product productFirst = new Product("manufacturer", "title", 0.5);
        final Product sameProductSecond = new Product("manufacturer", "title", 0.5);

        final String productID = productFirst.getProductID();

        productStorage.add(productFirst);
        boolean addStatus = productStorage.add(sameProductSecond);

        Map<String, List<Product>> actual = productStorage.getProducts();

        Map<String, List<Product>> expected = new HashMap<String, List<Product>>() {{
            put(productID, Arrays.asList(productFirst, sameProductSecond));
        }};

        assertTrue(addStatus);
        assertEquals(expected, actual);
        assertEquals(2, actual.get(productID).size());
    }

    @Test
    public void testRemoveProduct() {
        Product productFirst = new Product("manufacturer", "title", 0.5);
        Product productFake = new Product("manufacturer", "fake", 0.75);

        productStorage.add(productFirst);

        String expected = String.format("The product %s is absent in Product Storage", productFake.getTitle());
        try {
            productStorage.remove(productFake);
        } catch (IllegalArgumentException e) {
            assertEquals(expected, e.getMessage());
        }

    }

}