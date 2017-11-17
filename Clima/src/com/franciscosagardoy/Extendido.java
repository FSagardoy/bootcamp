package com.franciscosagardoy;

import java.util.Date;

public class Extendido {
    private int idExtendido;
    private String diaSemana;
    private int tempmin;
    private int tempmax;
    private Date fecha;
    private String descripcion;
    private int idClima;

    public int getIdExtendido() {
        return idExtendido;
    }

    public void setIdExtendido(int idExtendido) {
        this.idExtendido = idExtendido;
    }

    public String getDiaSemana() {
        return diaSemana;
    }

    public void setDiaSemana(String diaSemana) {
        this.diaSemana = diaSemana;
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

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getIdClima() {
        return idClima;
    }

    public void setIdClima(int idClima) {
        this.idClima = idClima;
    }
}
