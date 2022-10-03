package com.socket.tcp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class TCPCliente {
    
    public static void iniciar() {

        try {
            Socket socket = new Socket("localhost", 4000);
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            
            InputStreamReader inputStreamReader = new InputStreamReader(System.in);
            BufferedReader inReader = new BufferedReader(inputStreamReader);

            while ( !socket.isClosed() ) {
                String options = inReader.readLine();
                out.println(options);
                if ( options.equals("1") ) {

                }
                else if ( options.equals("3") ) {
                    System.out.println(in.readLine());
                    String num = inReader.readLine();
                    out.println(num);
                    System.out.println(in.readLine());
                }
                else if ( options.equals("4") ) {
                    System.out.println(in.readLine());
                    socket.close();                  
                }
                else if ( options.equals("5") ) {
                    System.out.println(in.readLine());
                    System.out.println(in.readLine());              
                }
                else if ( options.equals("6") ) {
                    System.out.println(in.readLine());
                    System.out.println(in.readLine());                
                }
            }

            inputStreamReader.close();
            inReader.close();
            socket.close();

        } catch (IOException e) {
            System.out.println(e);
        }
    }
}
