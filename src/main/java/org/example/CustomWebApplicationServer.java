package org.example;

import org.example.calculater.Calculator;
import org.example.calculater.PositiveNumber;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

/**
 * Http Protocol이 어떻게 생겼는지 알기
 * 규약이 있기 때문에 규악에 맞춰서 split을 할 수 있었고
 * 규약이 있기 때문에 규약에 맞춰서 response를 전달할 수 있었다.
 */

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
                 * step 1. 사용자 요청을 메인 Thread가 처리하도록 한다.
                 * ㄴ 만약 메인 Thread가 block이 걸리면, 다음 요청자는 게속 기다려야함
                 *
                 * step 2. 사용자 요청이 들어올 때 마다 Thread를 새로 생성해서 사용자 요청을 처리하도록 한다.
                 * ㄴ Runable 클래스를 만들어서 하는 일을 thread로 넘김
                 * ㄴ 근데 Thread는 생성될 때 마다 독립적인 static memory 공간을 할당받음
                 * ㄴ 이런 메모리를 할당받는 작업은 비싼 작업임
                 * ㄴ 사용자의 요청이 올 때 마다 Thread를 생성하게 되면 성능이 떨어짐
                 */
                new Thread(new ClientRequestHandler(clientSocket)).start();
            }
        }
    }
}
