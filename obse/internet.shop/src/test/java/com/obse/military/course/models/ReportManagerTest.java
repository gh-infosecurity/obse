package com.obse.military.course.models;

import com.obse.military.course.models.enums.ProductCategory;
import com.obse.military.course.models.interfaces.ProductStorageI;
import com.obse.military.course.service.ReportManager;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RunWith(MockitoJUnitRunner.class)
public class ReportManagerTest {
    private ReportManager reportManager;
    private List<Product> productList;
    private Map<String, List<Product>> products;
    private Report report;

    @Mock
    private ProductStorageI productStorageMock;

    @Before
    public void setUp() {
        reportManager = new ReportManager(productStorageMock);
        products = getProducts();
    }

    @Test
    public void testReportByPrice() {
        Mockito.when(productStorageMock.getProducts()).thenReturn(products);

        report = reportManager.getReportByPrice();

        report.print();
    }


    private Map<String, List<Product>> getProducts() {

        Product milk =  new Product("Bashtanka", "milk", 8.5);
        milk.setCategory(ProductCategory.MILKY);

        Product casio =  new Product("Japan", "casio", 850.5);
        casio.setCategory(ProductCategory.CLOCK);

        Product rolex =  new Product("Switzerland", "rolex", 999.0);
        rolex.setCategory(ProductCategory.CLOCK);

        Product book7 =  new Product("Piter", "Java-7", 35.7);
        book7.setCategory(ProductCategory.BOOKS);

        Product book8 =  new Product("oracle", "Java-8", 55.0);
        book8.setCategory(ProductCategory.BOOKS);

        Product designPattern =  new Product("oracle", "Design Pattern", 65.0);
        designPattern.setCategory(ProductCategory.BOOKS);

        Map<String, List<Product>> mapProducts = new HashMap<>(6);
        mapProducts.put(milk.getProductID(), Collections.singletonList(milk));
        mapProducts.put(casio.getProductID(), Collections.singletonList(casio));
        mapProducts.put(rolex.getProductID(), Collections.singletonList(rolex));
        mapProducts.put(book7.getProductID(), Collections.singletonList(book7));
        mapProducts.put(book8.getProductID(), Collections.singletonList(book8));
        mapProducts.put(designPattern.getProductID(), Collections.singletonList(designPattern));

        return mapProducts;
    }
}