package org.example;

import java.io.IOException;

// path : GET /calculate?oparand1=11&oparator=*&oparand2=55

/**
 * 1. 사용자 요청을 메인 Thread가 처리하도록 한다.
 * 2. 사용자 요청이 들어올 때 마다 Thread를 새로 생성해서 사용자 요청을 처리하도록 한다.
 * 3. ThreadPool을 적용해 안정적인 서비스가 가능하도록 한다.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        new CustomWebApplicationServer(8080).start();
    }
}