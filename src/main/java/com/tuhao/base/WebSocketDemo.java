package com.tuhao.base;
import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@ServerEndpoint("/webSocket")
public class WebSocketDemo {

    private static List list = new ArrayList<>();

    @OnMessage
    public void onMessage(String message,Session session) throws IOException, InterruptedException {

        System.err.println("Received:"+message);//打印客户端信息
        //向客户端发送消息
        session.getBasicRemote().sendText("This is the first server message! ");

        //每五秒发送三条信息到客户端
        int sendMessages = 0;
        while(sendMessages<3){
            Thread.sleep(2000);
            session.getBasicRemote().sendText("This is an intermediate server message. Count:"+sendMessages);
            sendMessages++;
        }
        //send the final message to the client
        session.getBasicRemote().sendText("This is the last message!");
    }

    @OnOpen
    public void onOpen(){

        System.err.println("Client connected !");
    }

//    @OnError
//    public void onError(){
//
//        System.err.println("Server is error!");
//    }

    @OnClose
    public void onClose(){

        System.err.println("Connection closed !");
    }





//    @Override
//    public void init(){
//
//        System.out.println("初始化方法！");
//    }
//
//    @Override
//    public void service(HttpServletRequest request, HttpServletResponse response){
//
//
//    }
//
//    @Override
//    public void destroy(){
//        System.out.println("销毁方法了！");
//    }
}
