package com.example.backend;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ToDoService {
    private final ToDoRepo repo;

    public ToDoService(ToDoRepo repo) {
        this.repo = repo;
    }

    public List<ToDo> getAllToDOs() {
        return repo.getToDos();
    }

    public List<ToDo> postToDo(ToDo newToDo) {
        String id= idGenerator();
        newToDo.setId(id);
        return repo.postToDo(newToDo);
    }

    public ToDo getToDo(String id) {
        return repo.getToDo(id);
    }

    public List<ToDo> putToDo(ToDo newToDo) {
        return repo.putToDo(newToDo);
    }

    public List<ToDo> deleteToDo(String id) {
        return repo.deleteToDo(id);
    }

    public String idGenerator(){
        return String.valueOf(repo.getToDos().size() +1);
    }

}
