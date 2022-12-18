package com.example.backend;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ToDoRepoTest {

    @Test
    void postToDo() {
        List<ToDo> toDos = new ArrayList<>(List.of(
                new ToDo("1","go to market",Status.OPEN),
                new ToDo("2", "shopping",Status.OPEN)
        ));
        ToDoRepo repo = new ToDoRepo(toDos);

        List<ToDo> actual = repo.postToDo(new ToDo("3","go to market",Status.OPEN));
        Assertions.assertEquals(List.of(
                new ToDo("1","go to market",Status.OPEN),
                new ToDo("2", "shopping",Status.OPEN),
                new ToDo("3","go to market",Status.OPEN)
        ),actual);
    }

    @Test
    void getToDo() {
        List<ToDo> toDos = new ArrayList<>(List.of(
                new ToDo("1","go to market",Status.OPEN),
                new ToDo("2", "shopping",Status.OPEN)
        ));
        ToDoRepo repo = new ToDoRepo(toDos);

        ToDo actual = repo.getToDo("2");
        Assertions.assertEquals(new ToDo("2", "shopping",Status.OPEN),actual);
    }

    @Test
    void getToDo_returnNull_WhenNoIdExist() {
        List<ToDo> toDos = new ArrayList<>(List.of(
                new ToDo("1","go to market",Status.OPEN),
                new ToDo("2", "shopping",Status.OPEN)
        ));
        ToDoRepo repo = new ToDoRepo(toDos);

        ToDo actual = repo.getToDo("5");
        Assertions.assertNull(actual);
    }

    @Test
    void getAllToDos() {
        List<ToDo> toDos = new ArrayList<>(List.of(
                new ToDo("1","go to market",Status.OPEN),
                new ToDo("2", "shopping",Status.OPEN)
        ));
        ToDoRepo repo = new ToDoRepo(toDos);

        List<ToDo> actual = repo.getToDos();
        Assertions.assertEquals(List.of(
                new ToDo("1","go to market",Status.OPEN),
                new ToDo("2", "shopping",Status.OPEN)
        ),actual);
    }

    @Test
    void putToDo() {
        List<ToDo> toDos = new ArrayList<>(List.of(
                new ToDo("1","go to market",Status.OPEN),
                new ToDo("2", "shopping",Status.OPEN)
        ));
        ToDoRepo repo = new ToDoRepo(toDos);

        List<ToDo> actual = repo.putToDo(new ToDo("1","meeting",Status.OPEN));
        Assertions.assertEquals(List.of(
                new ToDo("1","meeting",Status.OPEN),
                new ToDo("2", "shopping",Status.OPEN)
        ),actual);
    }

    @Test
    void deleteToDo() {
        List<ToDo> toDos = new ArrayList<>(List.of(
                new ToDo("1","go to market",Status.OPEN),
                new ToDo("2", "shopping",Status.OPEN)
        ));
        ToDoRepo repo = new ToDoRepo(toDos);

        List<ToDo> actual = repo.deleteToDo("1");
        Assertions.assertEquals(List.of(
                new ToDo("2", "shopping",Status.OPEN)
        ),actual);
    }
}