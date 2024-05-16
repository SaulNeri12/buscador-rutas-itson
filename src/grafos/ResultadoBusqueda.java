/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package grafos;

/**
 *
 * @author saul
 */
public class ResultadoBusqueda {
    private int distancias[];
    private int predecesores[];

    public ResultadoBusqueda(int distancias[], int predecesores[]) {
        this.distancias = distancias;
        this.predecesores = predecesores;
    }

    public int[] getDistancias() {
        return this.distancias;
    }

    public int[] getPredecesores() {
        return this.predecesores;
    }
    
    
}
