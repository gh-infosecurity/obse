package com.obse.military.course.models;

import com.obse.military.course.models.enums.ProductCategory;

public class Product implements Comparable {
    private String manufacturer;
    private String description;
    private ProductCategory category;
    private String title;
    private Double price;
    private String productID;

    public Product(String manufacturer, String title, Double price) {
        this.category = ProductCategory.OTHER;
        this.manufacturer = manufacturer;
        this.title = title;
        this.price = price;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public ProductCategory getCategory() {
        return category;
    }

    public void setCategory(ProductCategory category) {
        this.category = category;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getProductID() {
        return productID = manufacturer.concat(title).concat(String.valueOf(price));
    }

    @Override
    public int compareTo(Object o) {
        if (this.price > ((Product) o).price) {
            return 1;
        } else if (this.price < ((Product) o).price) {
            return -1;
        } else {
            return 0;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Product product = (Product) o;

        if (manufacturer != null ? !manufacturer.equals(product.manufacturer) : product.manufacturer != null)
            return false;
        if (description != null ? !description.equals(product.description) : product.description != null) return false;
        if (category != null ? !category.equals(product.category) : product.category != null) return false;
        if (title != null ? !title.equals(product.title) : product.title != null) return false;
        if (price != null ? !price.equals(product.price) : product.price != null) return false;
        return !(productID != null ? !productID.equals(product.productID) : product.productID != null);

    }

    @Override
    public int hashCode() {
        int result = manufacturer != null ? manufacturer.hashCode() : 0;
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (category != null ? category.hashCode() : 0);
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (price != null ? price.hashCode() : 0);
        result = 31 * result + (productID != null ? productID.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Product{" +
                "manufacturer='" + manufacturer + '\'' +
                ", description='" + description + '\'' +
                ", category='" + category + '\'' +
                ", title='" + title + '\'' +
                ", price=" + price +
                ", productID='" + productID + '\'' +
                '}';
    }
}
