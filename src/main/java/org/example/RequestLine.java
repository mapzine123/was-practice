package org.example;

import java.util.Objects;

/**
 * GET /calculate?oparand1=11&oparator=*&oparand2=55 HTTP/1.1
 */

public class RequestLine {
    private final String method; // GET
    private final String urlPath; ///calculate?oparand1=11&oparator=*&oparand2=55
    private QueryStrings queryStrings;

    public RequestLine(String requestLine) {
        String[] tokens = requestLine.split(" ");
        this.method = tokens[0];

        String[] urlPathTokens = tokens[1].split("\\?");
//        /calculate ? oparand1=11&oparator=*&oparand2=55
        this.urlPath = urlPathTokens[0]; // /calculate

        if(urlPathTokens.length == 2) {
            this.queryStrings = new QueryStrings(urlPathTokens[1]); // oparand1=11&oparator=*&oparand2=55
        }


    }

    public RequestLine(String method, String urlPath, String queryStrings) {
        this.method = method;
        this.urlPath = urlPath;
        this.queryStrings = new QueryStrings(queryStrings);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof RequestLine that)) return false;
        return Objects.equals(method, that.method) && Objects.equals(urlPath, that.urlPath) && Objects.equals(queryStrings, that.queryStrings);
    }

    @Override
    public int hashCode() {
        return Objects.hash(method, urlPath, queryStrings);
    }

    public boolean isGetRequest() {
        return "GET".equals(this.method);
    }

    public boolean matchPath(String requestPath) {
        return urlPath.equals(requestPath);
    }

    public QueryStrings getQueryStrings() {
        return this.queryStrings;
    }
}
