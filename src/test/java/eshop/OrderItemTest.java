package eshop;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class OrderItemTest {

    public double defaultProductPrice = 50;
    public int defaultOrderItemQuantity = 10;
    public Product product;
    public OrderItem orderItem;

    @BeforeEach
    void setup() {
        product = new Product(1, "Car", defaultProductPrice, 20);
        orderItem = new OrderItem(product, defaultOrderItemQuantity);
    }
    @Test
    void testCreate() {
        OrderItem orderItem = new OrderItem(product, 1);
        assertEquals(50,orderItem.getSubtotal());
    }
    @Test
    void testCreatequantityInt() {
        OrderItem orderItem = new OrderItem(product, 100);
        assertEquals(50*100,orderItem.getSubtotal());
    }

    @Test
    void testCreatequantity0Exception() {
        Throwable exception = assertThrows(IllegalArgumentException.class,
                () -> new OrderItem(product, 0));
        assertEquals("Order item quantity must be greater than zero", exception.getMessage());
    }

    @Test
    void testCreatequantityMinusException() {
        Throwable exception = assertThrows(IllegalArgumentException.class,
                () -> new OrderItem(product, -10));
        assertEquals("Order item quantity must be greater than zero", exception.getMessage());
    }

    @Test
    void testGetSubtotal() {
        assertEquals(defaultProductPrice * defaultOrderItemQuantity, orderItem.getSubtotal());
    }
}