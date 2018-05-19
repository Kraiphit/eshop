package eshop;

import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import java.time.LocalDateTime;
import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SuppressWarnings("ALL")
public class OrderTest {

    public Order order;

    @BeforeEach
    public void setup() {
        order = new Order(1, LocalDateTime.now());
    }
    @Test
    public void testCreate() {
        Order order  = new Order(2, LocalDateTime.now());
        assertEquals(2, order.getId());
    }

    public void testCreateIdMinusException() {
        Throwable exception = assertThrows(IllegalArgumentException.class,
                () -> new Order(-1, LocalDateTime.now()));
        assertEquals("Order ID must not be negative value", exception.getMessage());
    }

    @Test
    public void testGetTotal0() {
        assertEquals(0, order.getTotal());
    }

    @Test
    public void testGetTotal1Item() {
        Product product = new Product(1, "Car", 10, 10);
        order.addItem(product, 10);
        assertEquals(product.getPrice() * 10, order.getTotal());
    }

    @Test
    public void testGetTotal2Item() {
        Product product1 = new Product(1, "Car", 10, 10);
        Product product2 = new Product(3, "Van", 30, 30);
        order.addItem(product1, 10);
        order.addItem(product2, 30);
        assertEquals((product1.getPrice() * 10) + (product2.getPrice() * 5), order.getTotal());
    }
}