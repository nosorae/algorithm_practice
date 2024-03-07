package godofjava.com.basicjava.server.handler;

import godofjava.com.basicjava.server.dto.RequestDTO;
import godofjava.com.basicjava.server.manager.RequestManager;
import godofjava.com.basicjava.server.manager.ResponseManager;

import java.io.IOException;
import java.net.Socket;

public class RequestHandler extends Thread {
    Socket socket = null;

    public RequestHandler(Socket socket) {
        this.socket = socket;
    }
    @Override
    public void run() {
        RequestManager requestManager = new RequestManager(socket);
        RequestDTO dto = requestManager.readRequest();
        ResponseManager responseManager = new ResponseManager(socket, dto);
        responseManager.writeResponse();
    }
}
