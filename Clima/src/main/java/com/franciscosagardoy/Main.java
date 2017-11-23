package com.franciscosagardoy;



import dao.implement.GestorDAO;
import dao.implement.PaisImplementDAO;
import dao.interfaz.PaisDAO;

import java.sql.*;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws SQLException, ParseException {

        Scanner reader = new Scanner(System.in);
        int contador = 0;
        PaisDAO pais = new PaisImplementDAO();
        do{
            System.out.println("Ingrese el numero de lo que desea hacer: \nCrear: \n1: Pais \nMostrar \n2: Lista de paises \n3: Salir");
            int n = reader.nextInt();
            switch (n) {
                case 1: {
                    Pais p = new Pais();
                    System.out.println("Ingrese el codigo de 2 letras del pais");
                    String s = reader.next();
                    p.setCodAlfa2(s);
                    System.out.println("Ingrese el codigo de 3 letras del pais");
                    s = reader.next();
                    p.setCodAlfa3(s);
                    System.out.println("Ingrese el nombre del pais");
                    reader.nextLine();
                    s = reader.nextLine();
                    p.setNombre(s);
                    pais.insertPais(p);
                    break;
                }
                case 2:{
                    ArrayList<Pais> resultado = pais.getPaises();
                    for (int i = 0; i < resultado.size(); i++) {
                        System.out.println(i+1 + ": " + resultado.get(i).getNombre());

                    }
                    break;
                }
                /*case 3: {
                    Clima c = new Clima();
                    System.out.println("Seleccione el indice de la provincia: ");
                    ArrayList<Provincia> resultado = gestor.allProvincias();
                    for (int i = 0; i < resultado.size(); i++){
                        System.out.println(i + ": " + resultado.get(i).getNombre());
                    }
                    n = reader.nextInt();
                    c.setIdProvincia(resultado.get(n).getIdProvincia());
                    System.out.println("Ingrese los datos del clima \nTemperatura: ");
                    n = reader.nextInt();
                    c.setTemperatura(n);
                    System.out.println("Descripcion: ");
                    reader.nextLine();
                    String s = reader.nextLine();
                    c.setDescripcion(s);

                    Atmosfera at = new Atmosfera();
                    System.out.println("Ingrese los datos de la atmosfera: \nHumedad (0 a 100): ");
                    n = reader.nextInt();
                    at.setHumedad(n);
                    System.out.println("Presion (en hPa): ");
                    double d = reader.nextDouble();
                    at.setPresion(d);
                    System.out.println("Visibilidad (en km): ");
                    n = reader.nextInt();
                    at.setVisibilidad(n);
                    System.out.println("Ambiente ascendente (0 a 5): ");
                    n = reader.nextInt();
                    at.setAmbienteAscendente(n);
                    gestor.addAtmosfera(at);

                    Viento v = new Viento();
                    System.out.println("Ingrese los datos del viento \nVelocidad (en km/s): ");
                    n = reader.nextInt();
                    v.setVelocidad(n);
                    System.out.println("Direccion: ");
                    s = reader.next();
                    v.setDireccion(s);
                    gestor.addViento(v);

                    c.setIdAtmosfera(gestor.getIdAtmosfera());
                    c.setIdViento(gestor.getIdViento());

                    gestor.addClima(c);
                    ArrayList<Extendido> extendidos = new ArrayList<>();
                    Calendar calendar = Calendar.getInstance();
                    for (int i = 0; i < 10; i++) {
                        long aux = (calendar.getTimeInMillis() + (1000 * 60 * 60 * 24));
                        calendar.setTimeInMillis(aux);
                        Extendido extendido = new Extendido();
                        System.out.println("Ingrese el pronostico extendido: \nTemperatura minima: ");
                        extendido.setIdClima(gestor.getIdClima());
                        n = reader.nextInt();
                        extendido.setTempmin(n);
                        System.out.println("Temperatura maxima: ");
                        n = reader.nextInt();
                        extendido.setTempmax(n);
                        System.out.println("Descripcion: ");
                        reader.nextLine();
                        s = reader.nextLine();
                        extendidos.add(extendido);
                    }
                    gestor.addExtendido(extendidos);
                    break;
                }
                case 4:{
                    System.out.println("Seleccione el indice de la provincia:");
                    ArrayList<Provincia> resultado = gestor.allProvincias();
                    for (int i = 0; i < resultado.size(); i++){
                        System.out.println(resultado.get(i).getIdProvincia() + ": " + resultado.get(i).getNombre());
                    }
                    n = reader.nextInt();
                    System.out.println(gestor.getClimaHoy(n));
                    System.out.println("Pronostico Extendido");
                    for (Extendido extendido : gestor.getExtendidos(n)) {
                        System.out.println(extendido.ToString());
                    }
                }*/
                case 5:{
                    contador++;
                    break;
                }
                default:{
                    System.out.println("Usted ingreso una opcion invalida");
                }

            }

        } while (contador == 0);


        reader.close();


    }


}
