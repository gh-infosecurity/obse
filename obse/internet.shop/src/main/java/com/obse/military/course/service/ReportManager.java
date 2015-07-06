package com.obse.military.course.service;

import com.obse.military.course.models.Product;
import com.obse.military.course.models.Report;
import com.obse.military.course.models.interfaces.ProductStorageI;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class ReportManager {
    private ProductStorageI productStorage;

    public ReportManager(ProductStorageI productStorage) {
        this.productStorage = productStorage;
    }

    public Report getReportByPrice() {
        Map<String, List<Product>> products = productStorage.getProducts();
        List<Product> sortedProduct = getSortedProducts(products);

        Collections.sort(sortedProduct);

        return new Report(sortedProduct);
    }

    public Report getReportByCategory() {
        return null;
    }

    public Report getReportByManufacturer() {
        return null;
    }

    private List<Product> getSortedProducts(Map<String, List<Product>> products) {
        List<Product> sortedProduct = new ArrayList<>();

        for (Map.Entry<String, List<Product>> product : products.entrySet()) {
            sortedProduct.addAll(product.getValue());
        }
        return sortedProduct;
    }
}
