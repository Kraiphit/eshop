package eshop;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Iterator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;

class ProductCatalogTest {

    private ProductCatalog productCatalog;

    @BeforeEach
    void setup() {
        productCatalog = new ProductCatalog(new StubDataService());
        productCatalog.addAllProducts();
    }

    @Test
    void testGetProduct() {
        Product product = productCatalog.getProduct(1);
        assertEquals("Car", product.getName());
    }

    @Test
    void testGetProductNotIdReturnNull() {
        Product product = productCatalog.getProduct(0);
        assertEquals(null, product);
    }

    @Test
    void testGetProductAdd1Times() {
        Product product = new Product(4, "Plane", 40, 40);
        productCatalog.addProduct(product);
        assertSame(product, productCatalog.getProduct(4));
    }

    @Test
    void testGetProductAdd2Time() {
        Product product1 = new Product(4, "Plane", 40, 40);
        Product product2 = new Product(5, "Boat", 50, 50);
        productCatalog.addProduct(product1);
        productCatalog.addProduct(product2);
        assertSame(product1, productCatalog.getProduct(4));
        assertSame(product2, productCatalog.getProduct(5));
    }

    private class StubDataService implements IDataService {
        @Override
        public Iterator getAllObjects() {
            ArrayList<Product> list = new ArrayList<>();
            list.add(new Product(1, "Car", 10, 10));
            list.add(new Product(2, "Bicycle", 20, 20));
            list.add(new Product(3, "Van", 30, 30));
            return list.iterator();
        }
    }
}
