/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tests;

import grafos.Dijkstra;
import grafos.Locacion;
import java.util.Scanner;
import java.util.Stack;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author saul
 */
public class Main {

    public static void main(String[] args) {
        int[][] matriz = {
            {0, 6, 2, 0},
            {5, 0, 3, 5},
            {2, 3, 0, 3},
            {1, 10, 1, 0}
        };
        Dijkstra dijkstra = new Dijkstra(matriz);

        Scanner scanner = new Scanner(System.in);

        System.out.println("Seleccione el edificio de origen (1-15): ");
        int origen = scanner.nextInt() - 1;  // Convertimos a índice de matriz (0-14)

        System.out.println("Seleccione el edificio de destino (1-15): ");
        int destino = scanner.nextInt() - 1;  // Convertimos a índice de matriz (0-14)
        try {
            System.out.println(dijkstra.getTrazaBusquedaRutaMinima(origen, destino));
            System.out.println("Distancia recorrida: " + dijkstra.getDistanciaMinima(origen, destino));
        } catch (Exception ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }

        scanner.close();
        
        
        Locacion l = new Locacion(10, 10);
        
        int arr[] = {0, 2, 1, 4, 1};
        
        l.setAristasDistancias(arr);
        for (int i =0; i < l.getAristasDistancias().length; i++) {
            System.out.println(l.getAristasDistancias()[i]);
        }
        
        System.out.println("tamanio: " + l.getAristasDistancias().length);
        System.out.println("----------------------");
        
        int arr2[] = {0, 2, 1, 4, 1, 5, 6, 8, 1, 4};
        l.setAristasDistancias(arr2);
        for (int i =0; i < l.getAristasDistancias().length; i++) {
            System.out.println(l.getAristasDistancias()[i]);
        }
        
        System.out.println("tamanio: " + l.getAristasDistancias().length);
        
        
    }
    
    
}
