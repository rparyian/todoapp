package com.example.todoapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TodoService {

    private final TodoRepository todoRepository;

    @Autowired
    public TodoService(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }
    public List<Todo> getAllTodos() {
        return (List<Todo>) todoRepository.findAll();
    }

    public Optional<Todo> getTodoById(Long id) {
        return todoRepository.findById(id);
    }

    public Todo createTodo(Todo todo) {
        return todoRepository.save(todo);
    }

    public Todo updateTodo(Long id, Todo updatedTodo) {
        Optional<Todo> existingTodoOptional = todoRepository.findById(id);

        if (existingTodoOptional.isPresent()) {
            Todo existingTodo = existingTodoOptional.get();
            existingTodo.setTitle(updatedTodo.getTitle());
            existingTodo.setDescription(updatedTodo.getDescription());
            return todoRepository.save(existingTodo);
        } else {
            // Handle not found error or return null/throw an exception
            return null;
        }
    }

    public void deleteTodo(Long id) {
        Optional<Todo> todoOptional = todoRepository.findById(id);

        if (todoOptional.isPresent())
            todoRepository.deleteById(id);
    }
}
