package org.example;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RequestLineTest {
    @Test
    void create() {
        RequestLine requestLine = new RequestLine("GET /calculate?oparand1=11&oparator=*&oparand2=55 HTTP/1.1");

        assertThat(requestLine).isNotNull();
        assertThat(requestLine).isEqualTo(new RequestLine("GET", "/calculate", "oparand1=11&oparator=*&oparand2=55"));
    }
}
