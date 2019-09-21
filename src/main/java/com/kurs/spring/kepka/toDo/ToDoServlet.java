package com.kurs.spring.kepka.toDo;

import com.kurs.spring.kepka.hello.HelloServlet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServlet;
import java.util.List;

@RestController
@RequestMapping("/api/todos")
public class ToDoServlet extends HttpServlet {
    private final Logger logger = LoggerFactory.getLogger(HelloServlet.class);

    private ToDoRepository repository;


    private ToDoServlet(ToDoRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    ResponseEntity<List<ToDo>> findAllTodos() {
        logger.info("Got request");
        return ResponseEntity.ok(repository.findAll());
    }

    @PutMapping("/{id}")
    ResponseEntity<ToDo> toogleTodo(@PathVariable Integer id) {
        var todo = repository.findById(id);
        todo.ifPresent(t -> {
            t.setDone(!t.getDone());
            repository.save(t);
        });
        return todo.map(ResponseEntity::ok).orElse((ResponseEntity.notFound().build()));
    }

    @PostMapping
    ResponseEntity<ToDo> saveTodo(@RequestBody ToDo toDo) {
        return ResponseEntity.ok(repository.save(toDo));
    }
}
