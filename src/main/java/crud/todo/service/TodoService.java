package crud.todo.service;

import crud.todo.entity.Todo;
import crud.todo.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TodoService {

    @Autowired
    private TodoRepository todoRepository;
    @Autowired
    public TodoService(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    public Todo save(Todo todo) {
        return todoRepository.save(todo);
    }

    public Iterable<Todo> findAll() {
        return todoRepository.findAll();
    }

    public Todo findOne(long id) {
        return todoRepository.findById(id);
    }

    public void removeOne(long id) {
        todoRepository.deleteById(id);
    }

}
