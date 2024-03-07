package godofjava.e.network;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.Date;

// GodOfJava Vol2. 10장 연습문제
// TODO:: Socket.getOutputStream 후 Socket.getInputStream 하려고하면 데이터 서버로 전달 안되고 BufferedReader readLine에서 멈추는 이유? 동작원리 알아볼 필요 있음.
public class SocketClientSample {
    public static void main(String[] args) {
        SocketClientSample sample = new SocketClientSample();
        sample.sendSocketSample();
    }

    public void sendSocketSample() {
        for (int i = 0; i < 3; i++) {
            sendAndReceiveSocketData("are you ok now? :" + new Date());
        }
    }


    public void sendAndReceiveSocketData(String data) {
        Socket socket = null;
        try {
            System.out.println("Client:Connecting");
            socket = new Socket("127.0.0.1", 9999);
            System.out.println("Client:Connect status=" + socket.isConnected());

            InputStream inputStream = socket.getInputStream();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            String temp = null;
            StringBuilder receivedData = new StringBuilder();
            while ((temp = bufferedReader.readLine()) != null) {
                receivedData.append(temp);
            }
            System.out.println("Server send " + receivedData);


            bufferedReader.close();
            inputStream.close();
            System.out.println("----------");
        } catch (Exception e) {
            System.out.println("sendAndReceiveSocketData Exception");
            e.printStackTrace();
        } finally {
            if (socket != null) {
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
