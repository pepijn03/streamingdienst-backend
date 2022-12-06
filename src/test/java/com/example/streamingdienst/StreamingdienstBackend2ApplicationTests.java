package com.example.streamingdienst;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

@DataJpaTest
@TestPropertySource(locations = "classpath:test.properties")
@SpringBootTest
class StreamingdienstBackend2ApplicationTests {

    @Test
    void contextLoads() {

    }

}
