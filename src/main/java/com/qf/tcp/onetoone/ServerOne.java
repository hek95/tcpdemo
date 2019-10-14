package com.qf.tcp.onetoone;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

//服务端
//实现服务端与客户端一对一通话
public class ServerOne {
    public static void main(String[] args) throws IOException {
        //创建服务端socket
        ServerSocket ss = new ServerSocket(7777);
        System.out.println("服务器与客户端正在连接。。。");
        //接受客户端的socket
        Socket socket1 = ss.accept();
        System.out.println("服务器与客户端连接成功。。。");
        //创建网络输入输出流发送和读取客户端的消息
        //网络缓冲读取流 封装了基本的网络读取流封装了inputstream
        BufferedReader bis = new BufferedReader(new InputStreamReader(socket1.getInputStream()));
        BufferedWriter bwi = new BufferedWriter(new OutputStreamWriter(socket1.getOutputStream()));
        //读取客户端的信息
        String cword = bis.readLine();
        System.out.println("服务端接受客户端的消息为：" + cword);
        //回复客户端消息
        String sword = "hello client";
        bwi.write(sword);
        bwi.newLine();
        bwi.flush();
        System.out.println("服务器发送给客户端的消息为" + sword);
        //关对象 关流
        bis.close();
        bwi.close();
    }

}
