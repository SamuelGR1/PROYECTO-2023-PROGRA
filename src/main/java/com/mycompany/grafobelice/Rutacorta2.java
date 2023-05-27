/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.grafobelice;

import java.util.Scanner;

/**
 *
 * @author Samuel GR
 */
public class Rutacorta2 {
    
    private static final int NUM_DEPARTAMENTOS = 6;

    private static int[][] matrizDistancias = {
        
        {0, 124, 88, 47, 126, 230},        // BELICE
        { 124, 0, 162, 161, 100, 244},     // CAYO
        { 88, 162, 0, 41, 161, 279},       // COROZAL
        { 47, 161, 41, 0, 120, 238},       // Orange Walk
        { 126, 100, 161, 120, 0, 156},     // Stann Creek
        { 230, 244, 279, 238, 156, 0 },    // Toledo

    };

    public static void Buscar(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Departamentos de BELICE:");
        System.out.println("1. BELICE");
        System.out.println("2. CAYO");
        System.out.println("3. COROZAL");
        System.out.println("4. ORANGE WALK");
        System.out.println("5. STANN CREEK");
        System.out.println("6. TOLEDO");
       

    
        System.out.print("Ingrese el número del departamento de origen: ");
        int origen = scanner.nextInt();

        if (origen < 1 || origen > NUM_DEPARTAMENTOS) {
            System.out.println("Número de departamento no válido.");
            return;
        }

        System.out.print("Ingrese el número del departamento de destino: ");
        int destino = scanner.nextInt();

        if (destino < 1 || destino > NUM_DEPARTAMENTOS) {
            System.out.println("Número de departamento no válido.");
            return;
        }

        dijkstra(origen - 1, destino - 1);
    }

    private static void dijkstra(int origen, int destino) {
        int[] distancias = new int[NUM_DEPARTAMENTOS];
        boolean[] visitado = new boolean[NUM_DEPARTAMENTOS];

        for (int i = 0; i < NUM_DEPARTAMENTOS; i++) {
            distancias[i] = Integer.MAX_VALUE;
            visitado[i] = false;
        }

        distancias[origen] = 0;

        for (int i = 0; i < NUM_DEPARTAMENTOS - 1; i++) {
            int departamentoActual = obtenerMinimaDistancia(distancias, visitado);
            visitado[departamentoActual] = true;

            for (int j = 0; j < NUM_DEPARTAMENTOS; j++) {
                if (!visitado[j] && matrizDistancias[departamentoActual][j] != 0 &&
                        distancias[departamentoActual] != Integer.MAX_VALUE &&
                        distancias[departamentoActual] + matrizDistancias[departamentoActual][j] < distancias[j]) {
                    distancias[j] = distancias[departamentoActual] + matrizDistancias[departamentoActual][j];
                }
            }
        }

        mostrarRutaMasCorta(origen, destino, distancias);
    }

    private static int obtenerMinimaDistancia(int[] distancias, boolean[] visitado) {
        int minimaDistancia = Integer.MAX_VALUE;
        int minimoIndice = -1;

        for (int i = 0; i < NUM_DEPARTAMENTOS; i++) {
            if (!visitado[i] && distancias[i] <= minimaDistancia) {
                minimaDistancia = distancias[i];
                minimoIndice = i;
            }
        }

        return minimoIndice;
    }

    private static void mostrarRutaMasCorta(int origen, int destino, int[] distancias) {
        String[] nombresDepartamentos = {"BELICE", "CAYO", "COROZAL", "ORANGE WALK", "STANN CREEK", "TOLEDO"};

        System.out.println("La ruta más corta desde " + nombresDepartamentos[origen] + " hasta " + nombresDepartamentos[destino] + " es:");

        int distancia = distancias[destino];
        System.out.println("Distancia: " + distancia + " km");

        System.out.print("Ruta: ");
        int departamentoActual = destino;
        String ruta = nombresDepartamentos[destino] + " ";

        while (departamentoActual != origen) {
            for (int i = 0; i < NUM_DEPARTAMENTOS; i++) {
                if (matrizDistancias[i][departamentoActual] != 0 &&
                        distancias[departamentoActual] == distancias[i] + matrizDistancias[i][departamentoActual]) {
                    departamentoActual = i;
                    ruta = nombresDepartamentos[i] + " -> " + ruta;
                    break;
                }
            }
        }

        System.out.println(ruta);
    }
    
    
}
