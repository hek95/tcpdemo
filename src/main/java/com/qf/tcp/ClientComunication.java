package com.qf.tcp;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
//客户端
public class ClientComunication {
    public static void main(String[] args) throws    IOException {
        //创建socket对象 构造参数是服务器的地址和端口号
        Socket socket2=new Socket("192.168.1.101",9999);
        //创建网络输出流对象
        OutputStream os=socket2.getOutputStream();
        //准备客户端向服务端发送消息
        String cword="hello serve";
        //向服务器发送消息
        os.write(cword.getBytes());
        System.out.println("客户端向服务器发送消息为"+cword);
        //关对象
        os.close();
        socket2.close();


    }


}
