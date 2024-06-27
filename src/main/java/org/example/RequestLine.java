package org.example;

import java.util.Objects;

/**
 * GET /calculate?oparand1=11&oparator=*&oparand2=55 HTTP/1.1
 */

public class RequestLine {
    private final String method; // GET
    private final String urlPath; ///calculate?oparand1=11&oparator=*&oparand2=55
    private String queryString;

    public RequestLine(String requestLine) {
        String[] tokens = requestLine.split(" ");
        this.method = tokens[0];

        String[] urlPathTokens = tokens[1].split("\\?");
//        /calculate ? oparand1=11&oparator=*&oparand2=55
        this.urlPath = urlPathTokens[0]; // /calculate

        if(urlPathTokens.length == 2) {
            this.queryString = urlPathTokens[1]; // oparand1=11&oparator=*&oparand2=55
        }


    }

    public RequestLine(String method, String urlPath, String queryString) {
        this.method = method;
        this.urlPath = urlPath;
        this.queryString = queryString;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof RequestLine that)) return false;
        return Objects.equals(method, that.method) && Objects.equals(urlPath, that.urlPath) && Objects.equals(queryString, that.queryString);
    }

    @Override
    public int hashCode() {
        return Objects.hash(method, urlPath, queryString);
    }
}
