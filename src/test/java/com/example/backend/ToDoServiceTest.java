package com.example.backend;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.test.annotation.DirtiesContext;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;

@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
class ToDoServiceTest {
    List<ToDo> toDos = new ArrayList<>(List.of(
            new ToDo("1","go to market",Status.OPEN),
            new ToDo("2", "shopping",Status.OPEN)));
    ToDoRepo repo = mock(ToDoRepo.class);
    ToDoService service =new ToDoService(repo);

    @Test
    void getAllToDOs() {
        when(repo.getToDos()).thenReturn(toDos);
        List<ToDo> actual = service.getAllToDOs();
        Assertions.assertEquals(toDos,actual);
        verify(repo).getToDos();
    }

    @Test
    void postToDo() {
        ToDo toDo = new ToDo("3","meeting",Status.OPEN);
        when(repo.postToDo(toDo)).thenReturn(List.of(
                new ToDo("1","go to market",Status.OPEN),
                new ToDo("2", "shopping",Status.OPEN),
                new ToDo("3","meeting",Status.OPEN)));

        List<ToDo> actual = service.postToDo(toDo);
        Assertions.assertEquals(List.of(
                new ToDo("1","go to market",Status.OPEN),
                new ToDo("2", "shopping",Status.OPEN),
                new ToDo("3","meeting",Status.OPEN))
                ,actual);
        verify(repo).postToDo(toDo);
    }

    @Test
    void getToDo() {
        when(repo.getToDo("2")).thenReturn(new ToDo("2", "shopping",Status.OPEN));
        ToDo actual = service.getToDo("2");
        Assertions.assertEquals(new ToDo("2", "shopping",Status.OPEN),actual);
        verify(repo).getToDo("2");
    }

    @Test
    void putToDo() {
        ToDo toDo = new ToDo("1","meeting",Status.IN_PROGRESS);
        when(repo.putToDo(toDo)).thenReturn(List.of(
                new ToDo("1","meeting",Status.IN_PROGRESS),
                new ToDo("2", "shopping",Status.OPEN)));

        List<ToDo> actual = service.putToDo(toDo);
        Assertions.assertEquals(List.of(
                        new ToDo("1","meeting",Status.IN_PROGRESS),
                        new ToDo("2", "shopping",Status.OPEN))
                ,actual);
        verify(repo).putToDo(toDo);
    }

    @Test
    void deleteToDo() {
        when(repo.deleteToDo("2")).thenReturn(List.of(new ToDo("1","meeting",Status.OPEN)));
        List<ToDo> actual = service.deleteToDo("2");
        Assertions.assertEquals(List.of(new ToDo("1","meeting",Status.OPEN)),actual);
        verify(repo).deleteToDo("2");
    }
}