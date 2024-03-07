package godofjava.e.network;

import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

// GodOfJava Vol2. 10장 연습문제
// TODO:: Socket.getOutputStream 후 Socket.getInputStream 하려고하면 데이터 서버로 전달 안되고 BufferedReader readLine에서 멈추는 이유? 동작원리 알아볼 필요 있음.
public class SocketServerSample {
    public static void main(String[] args) {
        SocketServerSample sample = new SocketServerSample();
        sample.startReplyServer();
    }

    public void startReplyServer() {
        ServerSocket server = null;
        Socket client = null;
        try {
            server = new ServerSocket(9999);
            while (true) {
                System.out.println("Server:Waiting for request.");
                client = server.accept();

                OutputStream replyStream = client.getOutputStream();
                BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(replyStream);
                bufferedOutputStream.write(("OK: " + new Date()).getBytes());
                System.out.println("Server:Send response OK");

                bufferedOutputStream.close();
                replyStream.close();
                client.close();
                System.out.println("----------");
            }
        } catch (IOException e) {
            System.out.println("startReplyServer IOException");
            e.printStackTrace();
        } finally {
            if (server != null) {
                try {
                    server.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}


