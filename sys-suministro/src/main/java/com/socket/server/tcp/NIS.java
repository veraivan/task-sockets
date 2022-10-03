package com.socket.server.tcp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

public class NIS extends Thread {

    private Integer idNis;
    private Socket socket;
    private String estado;

    public NIS(Socket socket) {
        this.socket = socket;
        this.estado = "conectado";
    }
    
    @Override
    public void run() {

        try {

            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            InputStreamReader inputReader = new InputStreamReader(this.socket.getInputStream());
            BufferedReader in = new BufferedReader(inputReader);

            Map<String, Object> map = new HashMap<String, Object>();            
            String options;

            while ( !this.socket.isClosed() ) {
                options = in.readLine();
                if ( options.equals("1") ) {

                }
                else if ( options.equals("2") ) {
                    
                }
                else if ( options.equals("3") ) {
                    out.println("Número de NIS: ");
                    String n = in.readLine();
                    this.idNis = Integer.parseInt(n);
                    map.put("estado", 0);
                    map.put("mensaje", "ok");
                    map.put("tipo_operacion", "conexión_suministro");
                    out.println(map.toString());
                }

                else if ( options.equals("4") ) {
                    this.estado = "desconectado";
                    map.put("estado", 0);
                    map.put("mensaje", "ok");
                    map.put("tipo_operacion", "desconexión_suministro");
                    out.println(map.toString());
                    this.estado = "desconectado";
                    this.socket.close();
                }

                else if ( options.equals("5") ) {
                    String rp = TCPServer.listarActivos();
                    out.println(rp);
                    map.put("estado", 0);
                    map.put("mensaje", "ok");
                    map.put("tipo_operacion", "nis_activos");
                    out.println(map.toString());
                }

                else if ( options.equals("6") ) {
                    String rp = TCPServer.listarInactivos();
                    out.println(rp);
                    map.put("estado", 0);
                    map.put("mensaje", "ok");
                    map.put("tipo_operacion", "nis_inactivos");
                    out.println(map.toString());
                }
                else {
                    System.out.println(options);
                }
            }

            out.close();
            inputReader.close();
            in.close();

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
