package com.obse.military.course.models;

import java.util.List;

public class Report {
    private List<Product> products;

    public Report(List<Product> productReport) {
        this.products = productReport;
    }

    public void print() {
        for(Product product: products){
            System.out.print(product.getCategory()+"\t");
            System.out.print(product.getManufacturer()+"\t");
            System.out.print(product.getTitle() +"\t");
            System.out.println(product.getPrice());
        }
    }
}
