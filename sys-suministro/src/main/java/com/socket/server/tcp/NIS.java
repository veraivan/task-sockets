package com.socket.server.tcp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class NIS extends Thread {

    private Integer idNis;
    private Socket socket;
    private String estado;

    public NIS(Socket socket, Integer idNis) {
        this.socket = socket;
        this.idNis = idNis;
        this.estado = "conectado";
    }
    
    @Override
    public void run() {

        try {

            InputStreamReader in = new InputStreamReader(this.socket.getInputStream());
            BufferedReader bf = new BufferedReader(in);
            String fromClient;

            while ( !this.socket.isClosed() ) {
                fromClient = bf.readLine();

                if ( fromClient.equals("1") ) {
                    //agregar
                }
                else if ( fromClient.equals("2") ) {
                    //agregar
                }
            }


            in.close();
            bf.close();

            /*PrintWriter printWriter = new PrintWriter(socket.getOutputStream());
            printWriter.println("asdasdddasdasd");

            printWriter.close(); */       

        } catch (IOException e) {
            System.out.println(e);
        }
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getEstado() {
        return estado;
    }
    
    public Integer getIdNis() {
        return idNis;
    }

    public void closingSocket() {
        try {
            this.socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
