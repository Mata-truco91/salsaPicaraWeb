package com.salsapicara.demo;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
class SalsaPicaraWebApplicationTests {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void contextLoads() {
    }

    @Test
    void postPedidoRedirectsToPedidosPage() throws Exception {
        mockMvc.perform(post("/pedidos")
                .param("nombre", "Ana")
                .param("telefono", "5551234567")
                .param("cantidad", "2")
                .param("codigoPostal", "12345"))
                .andExpect(redirectedUrl("/pedidos"));
    }

}
