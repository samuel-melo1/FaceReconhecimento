package com.project.facereconhecimento;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import com.project.facereconhecimento.controller.PessoaControler;
//import javafx.application.Application;


@SpringBootTest
//@ContextConfiguration(classes=Application.class)
@WebMvcTest()
@DataJpaTest
@ExtendWith(MockitoExtension.class)
public class TestPessoa {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void whenValidInput_thenReturns200() throws Exception {
        // mockMvc.perform(MockMvcRequestBuilders
        // .get("/api/pessoa/create")
        // .contentType("application/json"))
        // .andExpect(MockMvcResultMatchers.status().is(200));
    }

}
