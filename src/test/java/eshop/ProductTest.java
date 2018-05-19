package eshop;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ProductTest {

    public Product product;

    @BeforeEach
    void setup() {
        product = new Product(1, "Car", 10, 10);
    }

    @Test
    void testCreateIdMinusException() {
        Throwable exception = assertThrows(IllegalArgumentException.class,
                () -> new Product(-1, "Bicycle", 20, 20));
        assertEquals("Product ID must not be negative value", exception.getMessage());
    }

    @Test
    void testCreateNameSpacesException() {
        Throwable exception = assertThrows(IllegalArgumentException.class,
                () -> new Product(2, "   ", 20, 20));
        assertEquals("Product name must not be empty", exception.getMessage());
    }

    @Test
    void testCreateNameBlankException() {
        Throwable exception = assertThrows(IllegalArgumentException.class,
                () -> new Product(2, "", 20, 20));
        assertEquals("Product name must not be empty", exception.getMessage());
    }

    @Test
    void testCreatePriceException() {
        Throwable exception = assertThrows(IllegalArgumentException.class,
                () -> new Product(2, "Bicycle", -20, 20));
        assertEquals("Product price must not be negative value", exception.getMessage());
    }

    @Test
    void testCreateQuantityMinusException() {
        Throwable exception = assertThrows(IllegalArgumentException.class,
                () -> new Product(2, "Bicycle", 20, -20));
        assertEquals("Product quantity must not be negative value", exception.getMessage());
    }

    @Test
    void testAddQuantityMinusException() {
        Throwable exception = assertThrows(IllegalArgumentException.class,
                () -> product.addQuantity(-10));
        assertEquals("Quantity must be greater than zero", exception.getMessage());
    }

    @Test
    void testAddQuantity0Exception() {
        Throwable exception = assertThrows(IllegalArgumentException.class,
                () -> product.addQuantity(0));
        assertEquals("Quantity must be greater than zero", exception.getMessage());
    }

    @Test
    void testAddQuantityIntPos() {
        product.addQuantity(10);
        assertEquals(20, product.getQuantity());
    }
}