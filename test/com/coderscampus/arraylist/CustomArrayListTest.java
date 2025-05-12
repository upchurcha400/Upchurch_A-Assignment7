package com.coderscampus.arraylist;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;

public class CustomArrayListTest {

    @Test
    public void should_add_item_to_list() {
        CustomList<String> list = new CustomArrayList<>();
        assertTrue(list.add("Item 1"));
        //confirm that the item was added and the size of the list is 1
        assertEquals(1, list.getSize());
        assertEquals("Item 1", list.get(0));
    }

    @Test
    public void should_add_item_to_specific_index() {
        CustomList<String> list = new CustomArrayList<>();
        list.add("Item 1");
        list.add("Item 3");
        //confirm that the items were added and the size of the list is 3
        assertTrue(list.add(1, "Item 2"));
        assertEquals(3, list.getSize());
        assertEquals("Item 2", list.get(1));
        assertEquals("Item 3", list.get(2));
    }

    @Test
    public void should_throw_exception_when_adding_item_at_invalid_index() {
        CustomList<String> list = new CustomArrayList<>();
        list.add("Item 1");
        //confirm that an exception is thrown when trying to add an item at an invalid index
        assertThrows(IndexOutOfBoundsException.class, () -> list.add(2, "Item 2"));
    }

    @Test
    public void should_return_item_at_specified_index() {
        CustomList<String> list = new CustomArrayList<>();
        list.add("Item 1");
        //confirm that the item at index 0 is "Item 1"
        assertEquals("Item 1", list.get(0));
    }

    @Test
    public void should_throw_exception_when_getting_item_at_invalid_index() {
        CustomList<String> list = new CustomArrayList<>();
        list.add("Item 1");
        //confirm that an exception is thrown when trying to get an item at an invalid index
        assertThrows(IndexOutOfBoundsException.class, () -> list.get(1));
    }

    @Test
    public void should_remove_item_at_specified_index() {
        CustomList<String> list = new CustomArrayList<>();
        list.add("Item 1");
        list.add("Item 2");
        list.add("Item 3");
        //confirm that the item at index 1 is removed and the size of the list is 2
        assertEquals("Item 2", list.remove(1));
        assertEquals(2, list.getSize());
        assertEquals("Item 3", list.get(1));
    }

    @Test
    public void should_throw_exception_when_removing_item_at_invalid_index() {
        CustomList<String> list = new CustomArrayList<>();
        list.add("Item 1");
        //confirm that an exception is thrown when trying to remove an item at an invalid index
        assertThrows(IndexOutOfBoundsException.class, () -> list.remove(1));
    }

    @Test
    public void should_resize_array_when_capacity_is_exceeded() {
        CustomList<Integer> list = new CustomArrayList<>();
        for (int i = 0; i < 20; i++) {
            list.add(i);
        }
        //confirm that the list has resized and the size is 20
        assertEquals(20, list.getSize());
        assertEquals(Integer.valueOf(19), list.get(19));
    }
}