package com.franciscosagardoy;

import java.util.Date;

public class Clima {
    private int idClima;
    private Date fecha;
    private int temperatura;
    private String descripcion;
    private int idViento;
    private int idAtmosfera;
    private int idProvincia;

    public int getIdClima() {
        return idClima;
    }

    public void setIdClima(int idClima) {
        this.idClima = idClima;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public int getTemperatura() {
        return temperatura;
    }

    public void setTemperatura(int temperatura) {
        this.temperatura = temperatura;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getIdViento() {
        return idViento;
    }

    public void setIdViento(int idViento) {
        this.idViento = idViento;
    }

    public int getIdAtmosfera() {
        return idAtmosfera;
    }

    public void setIdAtmosfera(int idAtmosfera) {
        this.idAtmosfera = idAtmosfera;
    }

    public int getIdProvincia() {
        return idProvincia;
    }

    public void setIdProvincia(int idProvincia) {
        this.idProvincia = idProvincia;
    }
}
