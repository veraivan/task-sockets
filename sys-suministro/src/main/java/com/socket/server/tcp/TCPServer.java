package com.socket.server.tcp;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class TCPServer {
    
    private static List<NIS> clientes;

    public TCPServer() {
        clientes = new ArrayList<NIS>();
    }

    public void iniciar() {

        try {
            ServerSocket serverSocket = new ServerSocket(4000);
            serverSocket.setSoTimeout(0);
            System.out.println("Servicios disponibles:");
            System.out.println("1 - Registrar consumo");
            System.out.println("2 - Informar conectividad");
            System.out.println("3 - Enviar orden de conexion");
            System.out.println("4 - Enviar orden de desconexión");
            System.out.println("5 - Listar NIS activos");
            System.out.println("6 - Listar NIS inactivos");

            while ( !serverSocket.isClosed() ) {
                Socket socket = serverSocket.accept();
                NIS nis = new NIS(socket);
                nis.start();
                clientes.add(nis);
            }

            serverSocket.close();

        } catch (IOException e1) {
            e1.printStackTrace();
        }
    }

    public static String listarActivos() {
        String activos = "";
        for (NIS nis : clientes) {
            if ( nis.getEstado().equals("conectado")) {
                String ms = "Nis " + nis.getId() + " " + nis.getEstado() + ", ";
                activos = activos + ms;
            }
        }
        return activos;
    }

    public static String listarInactivos() {
        String inactivos = "";
        for (NIS nis : clientes) {
            if ( nis.getEstado().equals("desconectado")) {
                String ms = "Nis " + nis.getId() + " " + nis.getEstado() + ", ";
                inactivos = inactivos + ms;
            }
        }
        return inactivos;
    }
}
