package com.project.facereconhecimento;



import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import com.project.facereconhecimento.controller.PessoaControler;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc

class FaceReconhecimentoApplicationTests {

    @Autowired
    private MockMvc mockMvc;
    private WebApplicationContext webApplicationContext;

    @Autowired
    private PessoaControler pessoaControler;


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
        // mockMvc.perform(MockMvcRequestBuilders
        //         .post("/api/pessoa/create")
        //         .contentType(MediaType.APPLICATION_JSON)
        //         .content("{\"id_pesssoa\": \"100\" \"ativo\": \"1\", \"cpf\": \"12256131912\": \"data_nascimento\": \"2004-12-20\",\"nome\": \"felipe\",\"tipo\": \"1\"}")
        //         .accept(MediaType.APPLICATION_JSON))
        //         .andExpect(MockMvcResultMatchers.status().is(200));

    }



}
