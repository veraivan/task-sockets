package com.socket.modelo;

import java.time.LocalDateTime;

public class RegistroOperaciones {
    
    private LocalDateTime fechaHora;
    private String origenIP;
    private String destinoIP;
    private String tipoOperacion;

    public RegistroOperaciones() {}

    public void setFechaHora(LocalDateTime fechaHora) {
        this.fechaHora = fechaHora;
    }

    public LocalDateTime getFechaHora() {
        return fechaHora;
    }

    public void setOrigenIP(String origenIP) {
        this.origenIP = origenIP;
    }

    public String getOrigenIP() {
        return origenIP;
    }

    public void setDestinoIP(String destinoIP) {
        this.destinoIP = destinoIP;
    }

    public String getDestinoIP() {
        return destinoIP;
    }

    public void setTipoOperacion(String tipoOperacion) {
        this.tipoOperacion = tipoOperacion;
    }

    public String getTipoOperacion() {
        return tipoOperacion;
    }
}
