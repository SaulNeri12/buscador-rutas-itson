
package grafos;

import java.awt.Color;
import java.awt.Point;

/**
 * Representa una locacion (edificio o cualquier lugar) en el mapa
 * @author saul
 */
public class Locacion extends Point {
    
    private String nombre;
    private Color colorPunto;
    private int id;
    
    private int aristasDistancias[];
    
    public Locacion(int x, int y) {
        this.x = x;
        this.y = y;
    }
    
    public void setAristasDistancias(int aristas[]) {
        
        this.aristasDistancias = new int[aristas.length];
        
        for (int i=0; i < aristas.length; i++) {
            if (i == this.id) {
                // hacemos que la distancia con el nodo mismo sea 0 siempre...
                this.aristasDistancias[this.id] = 0;
            } else {
                this.aristasDistancias[i] = aristas[i];
            }
        }
    }
    
    public int[] getAristasDistancias() {
        return this.aristasDistancias;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    
    public int getId() {
        return this.id;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public String getNombre() {
        return this.nombre;
    }
    
    public void setColor(Color color) {
        this.colorPunto = color;
    }
    
    public Color getColor() {
        return this.colorPunto;
    }
}
