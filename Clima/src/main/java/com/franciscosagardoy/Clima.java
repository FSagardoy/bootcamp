package com.franciscosagardoy;

import java.util.Date;

public class Clima {
    private int idClima;
    private Date fecha;
    private int temperatura;
    private int tempmin;
    private int tempmax;
    private String descripcion;
    private Viento viento;
    private Atmosfera atmosfera;
    private Localidad localidad;

    public Clima(){}

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

    public Viento getViento() {
        return viento;
    }

    public void setViento(Viento viento) {
        this.viento = viento;
    }

    public Atmosfera getAtmosfera() {
        return atmosfera;
    }

    public void setAtmosfera(Atmosfera atmosfera) {
        this.atmosfera = atmosfera;
    }

    public Localidad getLocalidad() {
        return localidad;
    }

    public void setLocalidad(Localidad localidad) {
        this.localidad = localidad;
    }

    public int getTempmin() {
        return tempmin;
    }

    public void setTempmin(int tempmin) {
        this.tempmin = tempmin;
    }

    public int getTempmax() {
        return tempmax;
    }

    public void setTempmax(int tempmax) {
        this.tempmax = tempmax;
    }

}



