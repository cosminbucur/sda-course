package com.sda.testing.advanced.controller;

import com.sda.testing.advanced.SpringTestingApplication;
import com.sda.testing.advanced.config.H2TestProfileJpaConfig;
import com.sda.testing.advanced.dto.BookRequest;
import com.sda.testing.advanced.service.BookService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.time.LocalDate;

@ActiveProfiles("test")
@ExtendWith(SpringExtension.class)
@AutoConfigureMockMvc
@SpringBootTest(
    webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT,
    classes = {SpringTestingApplication.class, H2TestProfileJpaConfig.class}
)
class ControllerMockMvcIntegrationTest {

    @LocalServerPort
    private static final int port = 8083;

    private static final String API_BOOKS = "/books";
    private static final String BASE_URI = "http://localhost:" + port + "/api";

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private BookService bookService;

    @BeforeEach
    void setUp() {
    }

    @Test
    void create() {
    }

    @Test
    void givenRequest_whenFindAll_thenReturn200() throws Exception {
        BookRequest request = new BookRequest();
        request.setTitle("game of thrones");
        request.setAuthor("george martin");
        request.setPublished(LocalDate.of(2000, 6, 30));
        bookService.save(request);

        mockMvc.perform(
            MockMvcRequestBuilders.get(BASE_URI + "/" + API_BOOKS)).
            andExpect(MockMvcResultMatchers.status().isOk()).
            andExpect(MockMvcResultMatchers.content()
                .string("[" +
                    "{\"id\":1," +
                    "\"title\":\"game of thrones\"," +
                    "\"author\":\"george martin\"," +
                    "\"published\":\"2000-06-30\"" +
                    "}]"));
    }

    @Test
    void findById() {
    }

    @Test
    void getBooksByAuthor() {
    }

    @Test
    void update() {
    }

    @Test
    void partialUpdate() {
    }

    @Test
    void delete() {
    }
}