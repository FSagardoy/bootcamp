package com.franciscosagardoy;

import java.sql.*;
import java.util.ArrayList;


public class GestorBD {

    String connection = "jdbc:mysql://localhost:3306/bootcamp";
    String user = "root";
    String password = "bootcamp2017";
    Connection conn;

    public void abrirConexion() throws SQLException{
        conn = DriverManager.getConnection(this.connection, user, this.password);
    }

    public void cerrarConexion() throws SQLException{
        conn.close();
    }

    public int addPais(Pais p) throws SQLException{
        this.abrirConexion();
        Statement st = conn.createStatement();
        String query = "insert into paises (cod_alfa2, cod_alfa3, nombre) values ('" +
                p.getCodAlfa2() + "', '" + p.getCodAlfa3() + "', '" + p.getNombre() + "')";
        int execute = st.executeUpdate(query);
        st.close();
        this.cerrarConexion();
        return execute;
    }

    public int addProv(Provincia prov) throws SQLException{
        this.abrirConexion();
        Statement st = conn.createStatement();
        String query = "insert into provincias (nombre, abreviatura, superficie, capital, idpais) values ('" +
                prov.getNombre() + "', '" + prov.getAbreviatura() + "', " + prov.getSuperficie() + ", '" + prov.getCapital() + "', " + prov.getIdPais() + ")";
        int execute = st.executeUpdate(query);
        st.close();
        this.cerrarConexion();
        return execute;
    }

    public int addClima(Clima c) throws SQLException{
        this.abrirConexion();
        Statement st = conn.createStatement();
        String query = "insert into climas (temperatura, descripcion, idviento, idatmosfera, idprovincia) values (" + c.getTemperatura() + ", '" + c.getDescripcion() + "', " + c.getIdViento()
                + ", " + c.getIdAtmosfera() + ", " + c.getIdProvincia() + ")";
        int execute = st.executeUpdate(query);
        st.close();
        this.cerrarConexion();
        return execute;
    }

    public int addViento(Viento v) throws SQLException{
        this.abrirConexion();
        Statement st = conn.createStatement();
        String query = "insert into vientos (velocidad, direccion) values (" + v.getVelocidad() + ", '" + v.getDireccion() + "')";
        int execute = st.executeUpdate(query);
        st.close();
        this.cerrarConexion();
        return execute;
    }

    public int addAtmosfera(Atmosfera at) throws SQLException{
        this.abrirConexion();
        Statement st = conn.createStatement();
        String query = "insert into atmosferas (humedad, presion, visibilidad, ambiente_asc) values (" + at.getHumedad() + ", " + at.getPresion() + ", " + at.getVisibilidad() + ", " + at.getAmbienteAscendente() + ")";
        int execute = st.executeUpdate(query);
        st.close();
        this.cerrarConexion();
        return execute;
    }

    public ArrayList<Pais> allPaises() throws SQLException{
        this.abrirConexion();
        ArrayList<Pais> paises = new ArrayList<>();
        Statement st = conn.createStatement();
        String query = "select * from paises";
        ResultSet res = st.executeQuery(query);
        while (res.next()){
            int id = res.getInt("idpais");
            String ca3 = res.getString("cod_alfa3");
            String ca2 = res.getString("cod_alfa2");
            String nom = res.getString("nombre");
            Pais p = new Pais();
            p.setIdPais(id);
            p.setCodAlfa3(ca3);
            p.setCodAlfa2(ca2);
            p.setNombre(nom);
            paises.add(p);
        }
        res.close();
        st.close();
        this.cerrarConexion();
        return paises;
    }

    public ArrayList<Provincia> allProvincias() throws SQLException{
        this.abrirConexion();
        ArrayList<Provincia> prov = new ArrayList<>();
        Statement st = conn.createStatement();
        String query = "select * from provincias";
        ResultSet res = st.executeQuery(query);
        while (res.next()){
            int id = res.getInt("idprovincia");
            String nom = res.getString("nombre");
            String abr = res.getString("abreviatura");
            int sup = res.getInt("superficie");
            String cap = res.getString("capital");
            int idpais = res.getInt("idpais");
            Provincia p = new Provincia();
            p.setIdProvincia(id);
            p.setNombre(nom);
            p.setAbreviatura(abr);
            p.setSuperficie(sup);
            p.setCapital(cap);
            p.setIdPais(idpais);
            prov.add(p);
        }
        res.close();
        st.close();
        this.cerrarConexion();
        return prov;
    }

    public ArrayList<Extendido> getExtendidos(int idProvincia) throws SQLException{
        this.abrirConexion();
        ArrayList<Extendido> extendidos = new ArrayList<>();
        Statement st = conn.createStatement();
        String query = "SELECT e.fecha, e.dia_semana, e.tempmax, e.tempmin, e.descripcion FROM extendidos e  join climas c on c.idclima = e.idclima WHERE YEAR(c.fecha) = YEAR(NOW()) AND MONTH(c.fecha) = MONTH(NOW()) AND DAY(c.fecha) = DAY(NOW()) AND c.idprovincia = " + idProvincia;
        ResultSet res = st.executeQuery(query);
        while (res.next()){
            Extendido extendido = new Extendido();
            extendido.setFecha(res.getDate("fecha"));
            extendido.setDiaSemana(res.getString("dia_semana"));
            extendido.setTempmax(res.getInt("tempmax"));
            extendido.setTempmin(res.getInt("tempmin"));
            extendido.setDescripcion(res.getString("descripcion"));
            extendidos.add(extendido);
        }
        res.close();
        st.close();
        this.cerrarConexion();
        return extendidos;
    }

    public String  getClimaHoy(int idProvincia) throws SQLException {
        String cadena = "";
        this.abrirConexion();
        Statement st = conn.createStatement();
        String query = "select p.nombre, p.capital, a.humedad, a.presion, a.visibilidad, a.ambiente_asc, v.velocidad, v.direccion, c.descripcion, c.temperatura from climas c join atmosferas a on a.idatmosfera = c.idatmosfera join vientos v on v.idviento = c.idviento join provincias p on p.idprovincia = c.idprovincia WHERE YEAR(c.fecha) = YEAR(NOW()) AND MONTH(c.fecha) = MONTH(NOW()) AND DAY(c.fecha) = DAY(NOW()) AND c.idprovincia = " + idProvincia;
        ResultSet res = st.executeQuery(query);
        if (res.next()){
            cadena = "Provincia: " + res.getString("nombre") + "\nCapital: " + res.getString("capital") + "\nClima:\nHumedad: " + res.getInt("humedad") + "\nPresion: "
                    + res.getDouble("presion") + "\nVisibilidad: " + res.getInt("visibilidad") + "\nAmbiente Ascendente: " + res.getInt("ambiente_asc") + "\nVelocidad del viento: " + res.getInt("velocidad")
                    + "\nDireccion: " + res.getString("direccion") + "\nTemperatura: " + res.getInt("temperatura") + "\nDescripcion: " + res.getString("descripcion") ;
        }
        res.close();
        st.close();
        this.cerrarConexion();
        return cadena;
    }

    public int getIdAtmosfera() throws  SQLException{
        this.abrirConexion();
        int id = 0;
        Statement st = conn.createStatement();
        String query = "select max(idatmosfera) as id from atmosferas";
        ResultSet res = st.executeQuery(query);
        while (res.next()){
            id = res.getInt("id");
        }
        res.close();
        st.close();
        this.cerrarConexion();
        return id;
    }

    public int getIdViento() throws  SQLException{
        this.abrirConexion();
        int id = 0;
        Statement st = conn.createStatement();
        String query = "select max(idviento) as id from vientos";
        ResultSet res = st.executeQuery(query);
        while (res.next()){
            id = res.getInt("id");
        }
        res.close();
        st.close();
        this.cerrarConexion();
        return id;
    }

    public int getIdClima() throws  SQLException{
        this.abrirConexion();
        int id = 0;
        Statement st = conn.createStatement();
        String query = "select max(idclima) as id from climas";
        ResultSet res = st.executeQuery(query);
        while (res.next()){
            id = res.getInt("id");
        }
        res.close();
        st.close();
        this.cerrarConexion();
        return id;
    }

    public boolean addExtendido(ArrayList<Extendido> extendidos){
        try {
            this.abrirConexion();
            Statement st = conn.createStatement();
            String query = "";
            for (Extendido extendido: extendidos) {
                query = "INSERT INTO extendidos (dia_semana, tempmin, tempmax, fecha, descripcion,idclima) VALUES (DAYNAME(date_add(NOW(),INTERVAL " + extendidos.indexOf(extendido) + " DAY)), "
                    + extendido.getTempmin() + ", " + extendido.getTempmax() + ", (date_add(NOW(),INTERVAL " + extendidos.indexOf(extendido) + " DAY)), '" + extendido.getDescripcion()+ "', " + extendido.getIdClima() + ")";
                st.execute(query);
            }
            st.close();
            this.cerrarConexion();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public GestorBD() throws SQLException {
    }

}