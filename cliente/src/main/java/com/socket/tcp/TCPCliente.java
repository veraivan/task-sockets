package com.socket.tcp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.Scanner;

public class TCPCliente {
    
    public static void iniciar() {

        try {
            Socket socket = new Socket("localhost", 4000);

            InputStreamReader in = new InputStreamReader(socket.getInputStream());
            BufferedReader bf = new BufferedReader(in);
            Scanner sn = new Scanner(System.in);
            int option;

            String fromServer;

            while ( !socket.isClosed() ) {
                fromServer = bf.readLine();
                if ( fromServer.equals("desconexion") ) {
                    socket.close();
                }
                else {
                    System.out.println(fromServer);
                }

                System.out.println("Servicios disponibles:");
                System.out.println("1 - Registrar consumo");
                System.out.println("2 - Listar consumo");
                option = sn.nextInt();

                if ( option == 1 ) {
                    //agregar
                }
                else if ( option == 2 ) {
                    //agregar
                }
            }

            in.close();
            bf.close();
            sn.close();

        } catch (IOException e) {
            System.out.println(e);
        }
    }
}
