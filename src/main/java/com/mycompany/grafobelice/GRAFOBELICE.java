/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.grafobelice;

import java.util.Scanner;

/**
 *
 * @author Samuel GR
 */
public class GRAFOBELICE {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Seleccione una opción:");
        System.out.println("1. Distancia general de departamentos");
        System.out.println("2. Ruta más corta");
        System.out.print("Opción: ");
        int opcion = scanner.nextInt();

        ejecutarOpcion(opcion);
    }

    private static void ejecutarOpcion(int opcion) {
        switch (opcion) {
            case 1:
            {
                
                Rutacorta.Distancias(null);
            }
               
                break;

            case 2:
                Rutacorta2.Buscar(null);
                
                break;
            default:
                System.out.println("Opción no válida.");
                break;
        }
    }
}
