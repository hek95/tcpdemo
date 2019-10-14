package com.qf.tcp;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Tcp Ip 四层模型
 * 应用层 通过应用程序给用户应用服务 http ftp 数据段
 * 网络层 网络信息传递和共享 Tcp UDP 数据包
 * 网络层 IP  IP和路由的选择  数据帧
 * 主机到网络层 硬件之间转管理连接
 * socket 套接字 表示ip地址和端口号的组合、
 * Tcp 服务器和客户端要进行三次握手 才能相互通信
 * 优点 安全 缺点 效率低
 */

/**
 * 实现tcp通信的 1.设置客户端类 1.创建serverSocket对象设置通信的端口 2.serverSocket调用accpet方法接受客户端的socket
 * 3.得到客户端的socket对象后得到其网络写入流 将获得信息读出来
 */


//服務器端
public class TcpComunication {
    public static void main(String[] args) throws IOException {
        //创建服务器socket对象
        ServerSocket ss=new ServerSocket(9999);
        System.out.println("服务器与客户端正在连接。。。");
        //用服务器socket对象调用方法监听客户端 并接受 这就是服务器与客户端的三次握手
        Socket socket1=ss.accept();
        System.out.println("服务器与客户端连接成功。。。");
        //读取客户端的信息 获得网络写入流  socket相当于信使
        InputStream is=socket1.getInputStream();
        //准备一个字节数组
        byte [] b=new byte[1024];
        //读取客户端的信息
        int len=is.read(b);
        //将读取的信息转化为string
        String cword=new String(b,0,len);
        System.out.println("服务器接受客户端的消息为"+cword);
    }

}
