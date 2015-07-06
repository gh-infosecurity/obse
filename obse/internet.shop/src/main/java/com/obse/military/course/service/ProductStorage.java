package com.obse.military.course.service;

import com.obse.military.course.models.Product;
import com.obse.military.course.models.interfaces.ProductStorageI;
import org.apache.commons.collections.CollectionUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductStorage implements ProductStorageI{
    private Map<String, List<Product>> products;

    public ProductStorage() {
        products = new HashMap<>();
    }

    public boolean add(Product product) {
        List<Product> productList = getProductList(product.getProductID());
        boolean addStatus = productList.add(product);
        products.put(product.getProductID(), productList);
        return addStatus;
    }

    public boolean remove(Product product) {
        List<Product> productList = products.get(product.getProductID());
        if(CollectionUtils.isNotEmpty(productList)) {
            return productList.remove(product);
        }else {
            throw new  IllegalArgumentException(String.format("The product %s is absent in Product Storage", product.getTitle()));
        }
    }

    public Map<String, List<Product>> getProducts() {
        return products;
    }

    private List<Product> getProductList(String productID) {
        List<Product> productList = products.get(productID);
        if (productList == null) {
            productList = new ArrayList<>();
        }
        return productList;
    }
}
