package godofjava.com.basicjava.server;

import godofjava.com.basicjava.server.handler.RequestHandler;

import java.io.BufferedInputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

// GodOfJava Vol2. 11장(기말고사) 연습문제
public class SimpleWebServer {
    public static void main(String[] args) {
        SimpleWebServer server = new SimpleWebServer();
        server.run(9000);
    }

    public void run(int port)  {
        ServerSocket server = null;
        try {
            server = new ServerSocket(port);
            while (true) {
                Socket socket = server.accept();
                RequestHandler handler=  new RequestHandler(socket);
                handler.start();
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
