package com.example.todoapp;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class TodoServiceTest {

    @Mock
    private TodoRepository todoRepository;

    @InjectMocks
    private TodoService todoService;

    @Test
    public void getAllTodos_ShouldReturnListOfTodos() {
        // Arrange
        when(todoRepository.findAll()).thenReturn(List.of(new Todo(), new Todo()));

        // Act
        var todos = todoService.getAllTodos();

        // Assert
        assertThat(todos).hasSize(2);
    }

    @Test
    public void getTodoById_ExistingId_ShouldReturnTodo() {
        // Arrange
        when(todoRepository.findById(1L)).thenReturn(Optional.of(new Todo()));

        // Act
        var todoOptional = todoService.getTodoById(1L);

        // Assert
        assertThat(todoOptional).isPresent();
    }

    @Test
    public void createTodo_ShouldReturnCreatedTodo() {
        // Arrange
        Todo todoToCreate = new Todo();
        when(todoRepository.save(any(Todo.class))).thenReturn(todoToCreate);

        // Act
        var createdTodo = todoService.createTodo(todoToCreate);

        // Assert
        assertThat(createdTodo).isNotNull();
    }

    @Test
    public void updateTodo_ExistingId_ShouldReturnUpdatedTodo() {
        // Arrange
        Long todoId = 1L;
        Todo existingTodo = new Todo();
        existingTodo.setId(todoId);
        existingTodo.setTitle("Old Title");
        existingTodo.setDescription("Old Description");

        Todo updatedTodo = new Todo();
        updatedTodo.setId(todoId);
        updatedTodo.setTitle("New Title");
        updatedTodo.setDescription("New Description");

        when(todoRepository.findById(todoId)).thenReturn(Optional.of(existingTodo));
        when(todoRepository.save(any(Todo.class))).thenReturn(updatedTodo);

        // Act
        var result = todoService.updateTodo(todoId, updatedTodo);

        // Assert
        assertThat(result).isNotNull();
        assertThat(result.getId()).isEqualTo(todoId);
        assertThat(result.getTitle()).isEqualTo(updatedTodo.getTitle());
        assertThat(result.getDescription()).isEqualTo(updatedTodo.getDescription());
    }

    @Test
    public void deleteTodo_ExistingId_ShouldInvokeDeleteMethod() {
        // Arrange
        Long todoId = 1L;
        when(todoRepository.findById(todoId)).thenReturn(Optional.of(new Todo()));

        // Act
        todoService.deleteTodo(todoId);

        // Assert
        verify(todoRepository, times(1)).findById(todoId);
        verify(todoRepository, times(1)).deleteById(todoId);
    }

    @Test
    public void deleteTodo_NonExistingId_ShouldNotInvokeDeleteMethod() {
        // Arrange
        Long nonExistingTodoId = 99L;

        // Act
        todoService.deleteTodo(nonExistingTodoId);

        // Assert
        verify(todoRepository, never()).deleteById(nonExistingTodoId);
    }

}
