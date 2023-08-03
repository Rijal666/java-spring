package crud.todo.controller;

import crud.todo.repository.TodoRepository;
import crud.todo.entity.Todo;
import crud.todo.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/v1")
public class TodoController {

    @Autowired
    private TodoService todoService;

    @Autowired
    private TodoRepository todoRepository;

    @RequestMapping(value = "/todos", method = RequestMethod.GET)
    public Iterable<Todo> findAll() {
        return todoService.findAll();
    }

    @RequestMapping(value = "/todo/{id}", method = RequestMethod.GET)
    public Todo findOne(@PathVariable("id") long id) {
        return todoService.findOne(id);
    }

    @RequestMapping(value = "/todo", method = RequestMethod.POST)
    public Todo save(@RequestBody Todo todo) {
        return todoService.save(todo);
    }

    @RequestMapping(value = "/todo/{id}", method = RequestMethod.PATCH)
    public ResponseEntity<Todo> findById(@PathVariable("id") long id, @RequestBody Todo todo) {
        Todo getTodo = todoRepository.findById(id);
        getTodo.setTitle(todo.getTitle());
        getTodo.setContent(todo.getContent());
        getTodo.setDone(todo.getDone());

        Todo updateTodo = todoRepository.save(getTodo);
        return ResponseEntity.ok().body(updateTodo);
    }

    @RequestMapping(value = "/todo/{id}", method = RequestMethod.DELETE)
    public void removeOne(@PathVariable("id") long id) {
        todoService.removeOne(id);
    }

}
