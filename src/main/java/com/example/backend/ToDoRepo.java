package com.example.backend;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Repository
public class ToDoRepo {
    private List<ToDo> toDos = new ArrayList<>(List.of(
            new ToDo("1","go to market",Status.OPEN),
            new ToDo("2", "shopping",Status.OPEN)
    ));


    public List<ToDo> postToDo(ToDo newToDo) {
        toDos.add(newToDo);
        return toDos;
    }

    public ToDo getToDo(String id) {
        ToDo toDo = null;
        for (ToDo t : toDos){
            if (t.getId().equals(id)){
                toDo = t;
                break;
            }
        }
        return toDo;
    }

    public List<ToDo> putToDo(ToDo newToDo) {
        for (ToDo t : toDos){
            if (t.getId().equals(newToDo.getId())){
                toDos.remove(t);
                toDos.add(newToDo);
                break;
            }
        }
        return toDos;
    }

    public List<ToDo> deleteToDo(String id) {
        toDos.removeIf(toDo ->(toDo.getId().equals(id)));
        return toDos;
    }

}
