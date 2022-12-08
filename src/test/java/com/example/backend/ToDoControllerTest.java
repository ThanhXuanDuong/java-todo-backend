package com.example.backend;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
class ToDoControllerTest {

    @Autowired
    private MockMvc mvc;
    @Test
    void getAllToDos() throws Exception {
        String expectedJson= """
        [
            {
                "id": "1",
                "description": "go to market",
                "status": "OPEN"
            },
            {
                "id": "2",
                "description": "shopping",
                "status": "OPEN"
            }
        ]
        """;

        //when & then
        mvc.perform(get("/api/todo"))
                .andExpect(status().isOk())
                .andExpect(content().json(expectedJson,true));
    }

    @Test
    void getToDo() throws Exception {
        String expectedJson= """
            {
                "id": "2",
                "description": "shopping",
                "status": "OPEN"
            }
        """;

        //when & then
        mvc.perform(get("/api/todo/2"))
                .andExpect(status().isOk())
                .andExpect(content().json(expectedJson,true));
    }

    @Test
    void postToDo() throws Exception {
        //given
        String requestBody="""
                {
                    "id": "3",
                    "description": "meeting",
                    "status": "OPEN"
                }
                """;
        String expectedJson= """
                {
                    "id": "3",
                    "description": "meeting",
                    "status": "OPEN"
                }
                """;
        //when & then
        mvc.perform(MockMvcRequestBuilders.post("/api/todo")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(requestBody))
                        .andExpect(status().isOk())
                        .andExpect(content().json(expectedJson,true));
    }

    @Test
    void putToDo() throws Exception {
        //given
        String requestBody="""
            {
                "id": "2",
                "description": "fitness",
                "status": "OPEN"
            }
                """;
        String expectedJson= """
            {
                "id": "2",
                "description": "fitness",
                "status": "OPEN"
            }
                """;
        //when & then
        mvc.perform(MockMvcRequestBuilders.put("/api/todo/2")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(requestBody))
                .andExpect(status().isOk())
                .andExpect(content().json(expectedJson,true));
    }

    @Test
    void deleteToDo() throws Exception {
        String expectedJson="""
           [
           {
                "id": "1",
                "description": "go to market",
                "status": "OPEN"
            }
            ]
                """;
        //when & then
        mvc.perform((MockMvcRequestBuilders.delete("/api/todo/2")))
                .andExpect(status().isOk())
                .andExpect(content().json(expectedJson,true));
    }
}