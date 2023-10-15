package br.com.digitalhouse.clinica;

import br.com.digitalhouse.produto.domain.entity.Clinica;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import static org.hamcrest.Matchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ActiveProfiles("test")
@SpringBootTest(classes = Clinica.class)
@AutoConfigureMockMvc
class ClinicaOdontoTests {
    @Autowired
    private MockMvc mvc;

    @Test
    void contextLoads() {Assertions.assertNotNull(mvc);}

    @Test
    void dadoRegistrosNoBanco_quandoChamamosEndpointReadAllClinicas_entaoRetornarTodasClinicas() throws Exception {
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders
                .get("/v1/clinica")
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON);

        this.mvc.perform(request)
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.content", hasSize(0)))
                .andExpect(jsonPath("$.totalElements", equalTo(0)))
                .andExpect(jsonPath("$", hasKey("size")));
    }

}
