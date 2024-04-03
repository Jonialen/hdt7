package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class BinaryTreeTest {
    private BinaryTree<Integer, String> tree;

    @BeforeEach
    public void setUp() {
        tree = new BinaryTree<>();
        tree.insert(5, "five");
        tree.insert(3, "three");
        tree.insert(7, "seven");
        tree.insert(2, "two");
        tree.insert(4, "four");
    }

    @Test
    public void testInsert() {
        // Se inserta una nueva asociación y se verifica que se encuentre en el árbol
        tree.insert(6, "six");
        assertEquals("six", tree.search(6));
    }

    @Test
    public void testSearchExistingKey() {
        // Se busca una clave existente y se verifica que devuelva el valor correcto
        assertEquals("five", tree.search(5));
        assertEquals("three", tree.search(3));
        assertEquals("seven", tree.search(7));
        assertEquals("two", tree.search(2));
        assertEquals("four", tree.search(4));
    }

    @Test
    public void testSearchNonExistingKey() {
        // Se busca una clave que no existe y se verifica que devuelva null
        assertNull(tree.search(1));
        assertNull(tree.search(6));
    }
}
