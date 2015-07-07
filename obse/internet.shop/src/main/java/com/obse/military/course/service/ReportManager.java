package com.obse.military.course.service;

import com.obse.military.course.models.Product;
import com.obse.military.course.models.Report;
import com.obse.military.course.models.interfaces.ProductStorageI;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
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

        Collections.sort(sortedProduct, getPriceComparator());

        return new Report(sortedProduct);
    }

    public Report getReportByCategory() {
        Map<String, List<Product>> products = productStorage.getProducts();
        List<Product> sortedProduct = getSortedProducts(products);

        Collections.sort(sortedProduct, getPriceComparator());

        return new Report(sortedProduct);
    }

    public Report getReportByManufacturer() {
        Map<String, List<Product>> products = productStorage.getProducts();
        List<Product> sortedProduct = getSortedProducts(products);

        Collections.sort(sortedProduct, getByManufacturerComparator());

        return new Report(sortedProduct);
    }

    private List<Product> getSortedProducts(Map<String, List<Product>> products) {
        List<Product> sortedProduct = new ArrayList<>();

        for (Map.Entry<String, List<Product>> product : products.entrySet()) {
            sortedProduct.addAll(product.getValue());
        }
        return sortedProduct;
    }

    private Comparator<? super Product> getPriceComparator() {
        return new Comparator<Product>() {
            @Override
            public int compare(Product lowProduct, Product highProduct) {
                if (lowProduct.getPrice() > highProduct.getPrice()) {
                    return 1;
                } else if (lowProduct.getPrice() < highProduct.getPrice()) {
                    return -1;
                } else {
                    return 0;
                }
            }
        };
    }

    private Comparator<? super Product> getByManufacturerComparator() {
        return new Comparator<Product>() {
            @Override
            public int compare(Product lowProduct, Product highProduct) {
                return lowProduct.getManufacturer().compareTo(highProduct.getManufacturer());
            }
        };
    }

    private Comparator<? super Product> getByCategoryComparator() {
        return new Comparator<Product>() {
            @Override
            public int compare(Product lowProduct, Product highProduct) {
                return lowProduct.getCategory().compareTo(highProduct.getCategory());
            }
        };
    }
}
