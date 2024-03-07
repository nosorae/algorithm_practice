package godofjava.com.basicjava.server.manager;

import godofjava.com.basicjava.server.dto.RequestDTO;

import java.io.PrintStream;
import java.net.Socket;
import java.util.Date;

// 사용자에게 전달할 응답의 내용

public class ResponseManager {
    Socket socket = null;
    RequestDTO dto = null;

    public ResponseManager(Socket socket, RequestDTO dto) {
        this.socket = socket;
        this.dto = dto;
    }

    public void writeResponse() {
        try {
            PrintStream response = new PrintStream((socket.getOutputStream()));
            response.println("HTTP/1.1 200 OK");
            response.println("Content-type: text/html");
            response.println();

            if (dto.getUri().equals("/today")) {
                response.print("today is " + new Date());
            } else {
                response.print("It's working");
            }

            response.flush();
            response.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}

