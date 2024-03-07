package godofjava.com.basicjava.server;

import java.io.BufferedInputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

// GodOfJava Vol2. 11장(기말고사) 연습문제
public class SimpleWebServerInitial {
    public static void main(String[] args) {
        SimpleWebServerInitial server = new SimpleWebServerInitial();
        int port = 9000;
        server.start(9000);
    }

    private final int BUFFER_SIZE = 2048;

    public void start(int port) {
        ServerSocket server = null;
        try {
            server = new ServerSocket(port);
            while (true) {
                Socket socket = server.accept();

                InputStream request = new BufferedInputStream(socket.getInputStream());
                byte[] receivedBytes = new byte[BUFFER_SIZE];
                request.read(receivedBytes);
                String requestData = new String(receivedBytes).trim();
                System.out.println("RequestData=\n" + requestData);
                System.out.println("-------------");

                PrintStream response = new PrintStream((socket.getOutputStream()));
                response.println("HTTP/1.1 200 OK");
                response.println("Content-type: text/html");
                response.println();
                response.print("It's working");
                response.flush();
                response.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (server != null) {
                try {
                    server.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
