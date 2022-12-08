package com.example.backend;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/todo")
public class ToDoController {
    private final ToDoService service;

    public ToDoController(ToDoService service) {
        this.service = service;
    }

    @GetMapping
    public List<ToDo> getAllToDos(){
        return service.getAllToDOs();
    }

    @GetMapping("/{id}")
    public ToDo getToDo(@PathVariable String id){
        return service.getToDo(id);
    }

    @PostMapping
    public ToDo postToDo(@RequestBody ToDo newToDo){
        service.postToDo(newToDo);
        return newToDo;
    }

    @PutMapping("/{id}")
    public ToDo putToDo(@RequestBody ToDo newToDo){
        service.putToDo(newToDo);
        return newToDo;
    }

    @DeleteMapping("/{id}")
    public List<ToDo> deleteToDo(@PathVariable String id){
        return service.deleteToDo(id);

    }
}
