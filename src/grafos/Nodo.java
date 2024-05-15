/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package grafos;

/**
 *
 * @author saul
 */
public class Nodo {
    private int id;
    private int distancia;

    public Nodo(int id, int distancia) {
        this.id = id;
        this.distancia = distancia;
    }
    
    public int getId() {
        return this.id;
    }
    
    public int getDistancia() {
        return this.distancia;
    }
}
