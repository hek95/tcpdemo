package com.qf.tcp.onetoone;

import java.io.*;
import java.net.Socket;

public class ClientOne {
    public static void main(String[] args) throws IOException {
        //创建socket对象
        Socket socket1=new Socket("192.168.1.101",7777);
        //创建网络流读取和发送消息
        BufferedReader br=new BufferedReader(new InputStreamReader(socket1.getInputStream()));
        BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(socket1.getOutputStream()));
         //客户端向服务器发送消息
        String cword ="hello 服务器！";
        bw.write(cword);
        //换行
        bw.newLine();
        bw.flush();
        System.out.println("客户端向服务器发送消息"+cword);
        //客户端接受服务器的消息
        String sword=br.readLine();
        System.out.println("客户端接受服务器的消息为"+sword);
        //关流
        bw.close();
        br.close();
    }
}
