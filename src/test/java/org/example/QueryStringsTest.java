package org.example;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class QueryStringsTest {
    @Test
    void createTest() {
        QueryStrings queryStrings = new QueryStrings("oparand1=11&oparator=*&oparand2=55"); // List<QueryString>

        assertThat(queryStrings).isNotNull();
    }
}
