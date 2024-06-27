package org.example;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class QueryStrings {
    private List<QueryString> queryStrings = new ArrayList<>();

    public QueryStrings(String queryStringLine) {
        // oparand1=11 & oparator=* & oparand2=55
        String[] queryStringTokens = queryStringLine.split("&");
        Arrays.stream(queryStringTokens)
                .forEach(queryString -> {
                    String[] values = queryString.split("=");
                    if (values.length != 2) {
                        throw new IllegalArgumentException("잘못된 QueryString 포맷을 가진 문자열입니다.");
                    }
                    queryStrings.add(new QueryString(values[0], values[1]));
                });
    }
}
