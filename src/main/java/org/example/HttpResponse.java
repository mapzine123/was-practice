package org.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.DataOutputStream;
import java.io.IOException;

public class HttpResponse {
    private static final Logger logger = LoggerFactory.getLogger(HttpResponse.class);

    private final DataOutputStream dos;

    public HttpResponse(DataOutputStream dos) {
        this.dos = dos;
    }
 
    // Header값 세팅
    public void response200Header(String contentType, int lengthOfBodyContent) {
        try {
            // Status
            dos.writeBytes("HTTP/1.1 200 OK \r\n");

            // Header
            dos.writeBytes("Content-Type: " + contentType + ";charset=utf-8\r\n");
            dos.writeBytes("Content-Length: " + lengthOfBodyContent + "\r\n");

            // Blank line
            dos.writeBytes("\r\n");
        } catch(IOException e) {
            logger.error(e.getMessage());
        }
    }
    
    // Body값 세팅
    public void responseBody(byte[] body) {
        try {
            dos.write(body, 0, body.length);
            dos.flush();
        } catch(IOException e) {
            logger.error(e.getMessage());
        }
    }
}
