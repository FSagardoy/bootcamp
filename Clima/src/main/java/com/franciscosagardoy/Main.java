package com.franciscosagardoy;



import dao.implement.PaisImplementDAO;

import java.sql.*;
import java.text.ParseException;
import java.util.ArrayList;
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
                case 3:{
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
