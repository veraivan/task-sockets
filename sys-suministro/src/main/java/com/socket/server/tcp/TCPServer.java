package com.socket.server.tcp;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TCPServer {
    
    private List<NIS> clientes;

    public TCPServer() {
        this.clientes = new ArrayList<NIS>();
    }

    public void iniciar() {
        String num = "0";

        try {
            ServerSocket serverSocket = new ServerSocket(4000);
            Scanner leer = new Scanner(System.in);

            while ( !serverSocket.isClosed() ) {
                pantalla();
                System.out.println();
                System.out.print("Ingrese el valor de la operación a realizar: ");
                num = leer.nextLine();

                switch (num) {
                    case "1":
                        break;
                    case "2":
                        conectar(serverSocket);
                        break;
                    case "3":
                        break;
                    case "4":
                        break;
                    case "5":
                        break;
                    case "6":
                        serverSocket.close();
                        break;
                    default:
                        break;
                }
            }

            leer.close();

        } catch (IOException e1) {
            e1.printStackTrace();
        }
    }

    public void pantalla() {
        System.out.println();
        System.out.println();
        System.out.println("Sistema Departamental de Suministros");
        System.out.println();
        System.out.println("Listado de operaciones:");
        System.out.println("1 - Informar conectividad");
        System.out.println("2 - Enviar orden de conexión");
        System.out.println("3 - Enviar orden de desconexión");
        System.out.println("4 - Listar NIS activos");
        System.out.println("5 - Listar NIS inactivos");
        System.out.println("6 - Apagar servidor");
    }

    public void conectar(ServerSocket serverSocket) {
        try {
            Scanner leer = new Scanner(System.in);
            System.out.println();
            System.out.print("Ingrese número del NIS a conectar: ");
            int num = leer.nextInt();
            serverSocket.setSoTimeout(0);
            Socket socket = serverSocket.accept();

            NIS nis = new NIS(socket, num);
            nis.start();
            this.clientes.add(nis);

            leer.close();

        } catch (SocketException e) {
            System.out.println(e);
        }
        catch( IOException e) {
            System.out.println(e);
        }
        
    }
}
