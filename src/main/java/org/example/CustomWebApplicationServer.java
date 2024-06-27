package org.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class CustomWebApplicationServer {
    private final int port;

    private static final Logger logger = LoggerFactory.getLogger(CustomWebApplicationServer.class);

    public CustomWebApplicationServer(int port) {
        this.port = port;
    }

    public void start() throws IOException {
        try (ServerSocket serverSocket = new ServerSocket(port)) { // 해당 포트로 ServerSocket 생성
            logger.info("[CustomWebApplicationServer] started {} port.", port);

            Socket clientSocket;
            logger.info("[CustomWebApplicationServer] waiting for client.");

            while ((clientSocket = serverSocket.accept()) != null) { // ServerSocket이 Client를 기다리게 한다.
                logger.info("[CustomWebApplicationServer] client connected!");
                /**
                 * 1. 사용자 요청을 메인 Thread가 처리하도록 한다.
                 */
                try (InputStream in = clientSocket.getInputStream(); OutputStream out = clientSocket.getOutputStream()) {
                    BufferedReader br = new BufferedReader(new InputStreamReader(in, StandardCharsets.UTF_8)); // line by line으로 읽어오기 위함
                    DataOutput dos = new DataOutputStream(out);

                    String line;
                    while((line = br.readLine()) != "") {
                        System.out.println(line);
                        /**
                         * GET /calculate?oparand1=11&oparator=*&oparand2=55 HTTP/1.1
                         * Host: localhost:8080
                         * Connection: Keep-Alive
                         * User-Agent: Apache-HttpClient/4.5.14 (Java/17.0.6)
                         * Accept-Encoding: br,deflate,gzip,x-gzip
                         */
                    }
                }
            }
        }
    }
}
