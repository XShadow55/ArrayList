package com.example.MethodArrayList;

import com.example.MethodArrayList.servis.impl.StringListImp;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class StringListImpTest {

    private final StringListImp stringListImp = new StringListImp();
    private StringListImp list = new StringListImp();

    @BeforeEach
    void setUp() {

        list.add("df");
        stringListImp.add("привет");
        stringListImp.add("как");
        stringListImp.add("дела");
        stringListImp.add("у тебя");
        stringListImp.add("дела");
    }

    @Test
    void add() {
        Assertions.assertEquals("привет",stringListImp.add("привет"));
    }

    @Test
    void testAdd() {
        Assertions.assertEquals("что",stringListImp.add(1,"что"));
        Assertions.assertEquals(1,stringListImp.indexOf("что"));
    }

    @Test
    void set() {
        Assertions.assertEquals("что",stringListImp.set(1,"что"));
        Assertions.assertEquals(1,stringListImp.indexOf("что"));
    }

    @Test
    void remove() {

        Assertions.assertEquals("как",stringListImp.remove("как"));

    }

    @Test
    void testRemove() {
        Assertions.assertEquals("как",stringListImp.remove("как"));

    }

    @Test
    void contains() {
        Assertions.assertTrue(stringListImp.contains("как"));
        Assertions.assertFalse(stringListImp.contains("xx"));
    }

    @Test
    void indexOf() {
        Assertions.assertEquals(1,stringListImp.indexOf("как"));
        Assertions.assertEquals(-1,stringListImp.indexOf("вв"));
    }

    @Test
    void lastIndexOf() {
        Assertions.assertEquals(4,stringListImp.lastIndexOf("дела"));
        Assertions.assertEquals(-1,stringListImp.lastIndexOf("вв"));
    }

    @Test
    void get() {
        Assertions.assertEquals("как",stringListImp.get(1));

    }

    @Test
    void testEquals() {
        Assertions.assertFalse(stringListImp.equals(list));
    }

    @Test
    void size() {
        Assertions.assertEquals(5,stringListImp.size());
    }

    @Test
    void isEmpty() {
        Assertions.assertFalse(stringListImp.isEmpty());
    }
}