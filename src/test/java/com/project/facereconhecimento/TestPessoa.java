package com.project.facereconhecimento;


import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;


@SpringBootTest

@WebAppConfiguration
@MockBean
@SpringJUnitConfig
public class TestPessoa {

    @Autowired
    private MockMvc mockMvc;


    @Test
    public void testCadastrar() throws Exception{


    }
}
