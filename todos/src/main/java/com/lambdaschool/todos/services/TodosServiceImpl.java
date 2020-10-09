package com.lambdaschool.todos.services;

import com.lambdaschool.todos.models.Todo;
import com.lambdaschool.todos.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;

@Transactional
@Service(value = "todosService")
public class TodosServiceImpl implements TodosService{
    @Autowired
    TodoRepository todoRepository;

    @Override
    public void markComplete(long todoid) {
        Todo target = todoRepository.findById(todoid).orElseThrow(() -> new EntityNotFoundException("Could not find todo with ID '" + todoid + "'."));
        target.setCompleted(true);
    }
}
