package godofjava.com.basicjava.server.manager;

import godofjava.com.basicjava.server.dto.RequestDTO;

import java.io.BufferedInputStream;
import java.io.InputStream;
import java.net.Socket;

// 사용자의 요청을 읽어 분석
public class RequestManager {
    Socket socket = null;
    private final int BUFFER_SIZE = 2048;

    public RequestManager(Socket socket) {
        this.socket = socket;
    }

    public RequestDTO readRequest() {
        try {
            InputStream request = new BufferedInputStream(socket.getInputStream());
            byte[] receivedBytes = new byte[BUFFER_SIZE];
            request.read(receivedBytes);
            String requestData = new String(receivedBytes).trim();
            System.out.println("RequestData=\n" + requestData);

            RequestDTO dto = new RequestDTO();
            String[] requests = requestData.split("\n");
            dto.setRequestMethod(requests[0].split(" ")[0]);
            dto.setUri(requests[0].split(" ")[1]);
            dto.setHttpVersion(requests[0].split(" ")[2]);
            return dto;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
