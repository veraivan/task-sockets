package com.socket.modelo;

public class Consumo {

    private String decripcion;
    private Integer potenciaWatts;
    private Integer horasUtilizacion;
    private Integer consumoMensual;
    private Integer idNis;

    public Consumo() {} 

    public void setDecripcion(String decripcion) {
        this.decripcion = decripcion;
    }

    public String getDecripcion() {
        return decripcion;
    }

    public void setPotenciaWatts(Integer potenciaWatts) {
        this.potenciaWatts = potenciaWatts;
    }

    public Integer getPotenciaWatts() {
        return potenciaWatts;
    }

    public void setConsumoMensual(Integer consumoMensual) {
        this.consumoMensual = consumoMensual;
    }

    public Integer getConsumoMensual() {
        return consumoMensual;
    }

    public void setHorasUtilizacion(Integer horasUtilizacion) {
        this.horasUtilizacion = horasUtilizacion;
    }

    public Integer getHorasUtilizacion() {
        return horasUtilizacion;
    }

    public void setIdNis(Integer idNis) {
        this.idNis = idNis;
    }

    public Integer getIdNis() {
        return idNis;
    }
}
