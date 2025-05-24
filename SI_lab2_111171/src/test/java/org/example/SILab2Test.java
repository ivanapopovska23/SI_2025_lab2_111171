package org.example;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.List;

public class SILab2Test {

    @BeforeAll
    static void init() {
        System.out.println("@BeforeAll - Not that it matters, but I have a cat named Mushu. It's adorable");
    }

    @AfterAll
    static void destroy() {
        System.out.println("@AfterAll - ...and also annoying :)");
    }

    @Test
    public void testEveryStatementCriteria() {
        RuntimeException ex1;
        // null list
        ex1 = assertThrows(RuntimeException.class, () -> SILab2.checkCart(null, "1234123412341234"));
        assertTrue(ex1.getMessage().contains("allItems list can't be null!"));

        // Nameless item
        final List<Item> tiramisuIngredients = Arrays.asList(
                new Item("Mascarpone", 4, 400, 0.2),
                new Item("Ladyfingers", 12, 180, 0),
                new Item("", 1, 200, 0)
        );
        RuntimeException ex2;
        ex2 = assertThrows(RuntimeException.class, () -> SILab2.checkCart(tiramisuIngredients, "1234123412341234"));
        assertTrue(ex2.getMessage().contains("Invalid item!"));

        // Card number length incorrect
        RuntimeException ex3;
        ex3 = assertThrows(RuntimeException.class, () -> SILab2.checkCart(List.of(new Item("Eggs", 10, 100, 0)), "1234"));
        assertTrue(ex3.getMessage().contains("Invalid card number!"));

        // Card number invalid
        RuntimeException ex4;
        ex4 = assertThrows(RuntimeException.class, () -> SILab2.checkCart(List.of(new Item("Eggs", 10, 100, 0)), "123a234b345c456d"));
        assertTrue(ex4.getMessage().contains("Invalid character in card number!"));

        // All under control :)
        assertNotEquals(500, SILab2.checkCart(List.of(new Item("Vanilla", 1, 500, 0)), "1234123412341234"));
        assertEquals(470, SILab2.checkCart(List.of(new Item("Vanilla", 1, 500, 0)), "1234123412341234"));
    }

    @Test
    public void testMultipleConditionCriteria() {
        final List<Item> items = Arrays.asList(
                new Item ("Cabernet Sauvignon", 1, 599, 0), // TXX
                new Item ("Mortadella", 2, 89, 0.1), // FTX
                new Item ("French croissant", 12, 300, 0), // FFT
                new Item ("Cat food", 1, 299, 0) // FFF
        );

        assertEquals(4568.2, SILab2.checkCart(items, "1234123412341234"));
    }
}