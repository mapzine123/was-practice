package org.example;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class QueryStringTest {
    // oparand1=11&oparator=*&oparand2=55
    @Test
    void createTest() {
        QueryString queryString = new QueryString("operand1", "11");

        assertThat(queryString).isNotNull();

    }
}
