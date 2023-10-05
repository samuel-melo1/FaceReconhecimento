package com.project.facereconhecimento;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import com.project.facereconhecimento.controller.PessoaControler;
import com.project.facereconhecimento.repository.PessoaRepository;

import jakarta.validation.constraints.AssertTrue;

import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc

class FaceReconhecimentoApplicationTests {

    @Autowired
    private MockMvc mockMvc;
    private WebApplicationContext webApplicationContext;

    @Autowired
    private PessoaControler pessoaControler;

    @Autowired
    private PessoaRepository repository;


    @Before(value = "")
    public void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(PessoaControler.class).build();
    }

    @Test
    public void responseHttpTest() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders
                .get("/api/pessoa/listagem?pageNumber=0&pageSize=2"))
                .andExpect(MockMvcResultMatchers.status().is(200));
    }

    @Test
    public void cadastrarTest() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders
                .post("/api/pessoa/create")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\r\n" + 
                        "\t\"id_pessoa\": 114,\r\n" + 
                        "\t\"nome\": \"romenia\",\r\n" + 
                        "\t\"cpf\": \"12256131912\",\r\n" + 
                        "\t\"data_nascimento\": null,\r\n" + 
                        "\t\"tipo\": \"responsavel\",\r\n" + 
                        "\t\"ativo\": true,\r\n" + 
                        "\t\"log\": null\r\n" + 
                        "}")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().is(200));
    }
    
    @Test
    public void getAllTest() throws Exception {

        mockMvc.perform(MockMvcRequestBuilders
               .get("/api/pessoa/search")
               .contentType(MediaType.APPLICATION_JSON))
               .andExpect(MockMvcResultMatchers.status().is(200));

    
    }

        @Test
    public void getByIdTest() throws Exception {

        mockMvc.perform(MockMvcRequestBuilders
               .get("/api/pessoa/busca/1")
               .contentType(MediaType.APPLICATION_JSON))
               .andExpect(MockMvcResultMatchers.status().is(200));
         
    }

}
