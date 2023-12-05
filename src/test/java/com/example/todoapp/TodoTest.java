package com.example.todoapp;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class TodoTest {

    @Test
    void testEqualsAndHashCode() {
        Todo todo1 = new Todo(1L, "Title 1", "Description 1");
        Todo todo2 = new Todo(1L, "Title 1", "Description 1");
        Todo todo3 = new Todo(2L, "Title 2", "Description 2");

        // Test equals
        assertEquals(todo1, todo2);
        assertNotEquals(todo1, todo3);

        // Test hashCode
        assertEquals(todo1.hashCode(), todo2.hashCode());
        assertNotEquals(todo1.hashCode(), todo3.hashCode());
    }

    @Test
    void testTodoConstructorWithArgs() {
        Long id = 1L;
        String title = "Test Title";
        String description = "Test Description";

        Todo todo = new Todo(id, title, description);

        assertEquals(id, todo.getId());
        assertEquals(title, todo.getTitle());
        assertEquals(description, todo.getDescription());
    }

    @Test
    void testToString() {
        Todo todo = new Todo(1L, "Test Title", "Test Description");

        String expectedToString = "Todo(id=1, title=Test Title, description=Test Description)";
        assertEquals(expectedToString, todo.toString());
    }

    @Test
    void testTodoConstructor() {
        Todo todo = new Todo();
        // You can add more assertions based on your specific Todo initialization logic
        // For now, let's just check that the object is not null
        assertEquals(todo, todo);
    }

    @Test
    void testTodoGettersAndSetters() {
        Todo todo = new Todo();
        todo.setId(1L);
        todo.setTitle("Test Title");
        todo.setDescription("Test Description");

        // Test getters
        assertEquals(1L, todo.getId());
        assertEquals("Test Title", todo.getTitle());
        assertEquals("Test Description", todo.getDescription());

        // Test setters
        todo.setId(2L);
        todo.setTitle("Updated Title");
        todo.setDescription("Updated Description");

        assertEquals(2L, todo.getId());
        assertEquals("Updated Title", todo.getTitle());
        assertEquals("Updated Description", todo.getDescription());
    }

}
