package com.socket;

import com.socket.server.tcp.TCPServer;

public class App 
{
    public static void main( String[] args ) {
        TCPServer tcpServer = new TCPServer();
        tcpServer.iniciar();
    }
}
