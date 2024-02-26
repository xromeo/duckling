package com.rivera.duckling.controller;

import com.rivera.duckling.entity.Duckling;
import com.rivera.duckling.entity.Size;
import com.rivera.duckling.repository.DucklingRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.math.BigInteger;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class DucklingControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    DucklingRepository ducklingRepository;

    List<Duckling> ducklingList = new ArrayList<>();

    @BeforeEach
    void setUp() {
        Duckling duckling1 = new Duckling();
        duckling1.setPurchaseDate(LocalDate.of(2021, 2, 25));
        duckling1.setId(BigInteger.valueOf(10L));
        duckling1.setColor("RED");
        duckling1.setQuantity(100);
        duckling1.setSize(Size.LARGE);
        duckling1.setPrice(10.0);
        duckling1.setProvider("HASSBRO");
        duckling1.setCountryOrigin("CHINA");
        duckling1.setProductionDate(LocalDate.of(2013, 3, 17));

        Duckling duckling2 = new Duckling();
        duckling2.setPurchaseDate(LocalDate.of(2021, 2, 25));
        duckling2.setId(BigInteger.valueOf(11L));
        duckling2.setColor("BLACK");
        duckling2.setQuantity(100);
        duckling2.setSize(Size.SMALL);
        duckling2.setPrice(10.0);
        duckling2.setProvider("MATTEL");
        duckling2.setCountryOrigin("CHINA");
        duckling2.setProductionDate(LocalDate.of(2013, 3, 17));

        ducklingList = List.of(duckling1, duckling2);
    }

    @Test
    void shouldFindAll() throws Exception {

        String jsonResponse = """
                [{"id":10,"color":"RED","size":"LARGE","price":10.0,"quantity":100,"provider":"HASSBRO","countryOrigin":"CHINA","productionDate":"2013-03-17","purchaseDate":"2021-02-25"},{"id":11,"color":"BLACK","size":"SMALL","price":10.0,"quantity":100,"provider":"MATTEL","countryOrigin":"CHINA","productionDate":"2013-03-17","purchaseDate":"2021-02-25"}]
                """;

        when(ducklingRepository.getDucklingByActive(Boolean.TRUE)).thenReturn(ducklingList);

        mockMvc.perform(get("/api/v1/duckling/")
                        .contentType(MediaType.APPLICATION_JSON)
                )

                .andExpect(status().isOk())
                .andExpect(content().json(jsonResponse));

    }
}