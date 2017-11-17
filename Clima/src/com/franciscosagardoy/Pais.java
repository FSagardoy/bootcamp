package com.franciscosagardoy;

public class Pais {
    private int idPais;
    private String nombre;
    private String codAlfa2;
    private String codAlfa3;

    public void setNombre(String nombre){
        this.nombre = nombre;
    }

    public String getNombre(){
        return nombre;
    }

    public void setCodAlfa2(String codAlfa2){
        this.codAlfa2 = codAlfa2;
    }

    public String getCodAlfa2(){
        return codAlfa2;
    }

    public void setCodAlfa3(String codAlfa3){
        this.codAlfa3 = codAlfa3;
    }

    public String getCodAlfa3(){
        return codAlfa3;
    }

    public int getIdPais() {
        return idPais;
    }

    public void setIdPais(int idPais) {
        this.idPais = idPais;
    }
}
