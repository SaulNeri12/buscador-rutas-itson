
package grafos;

import java.awt.Color;
import java.awt.Point;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

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
        this.colorPunto = Color.BLACK;
    }
    
    
    public void setAristasDistancias(int arrDistancias[]) {
        
        if (arrDistancias == null) {
            return; // No hacemos nada si el arreglo es nulo
        }

        if (this.aristasDistancias == null || arrDistancias.length > this.aristasDistancias.length) {
            // Si el arreglo actual es nulo o el nuevo arreglo es más grande,
            // creamos un nuevo arreglo con el tamaño del nuevo arreglo
            int[] nuevoArreglo = new int[arrDistancias.length];

            // Si hay un arreglo actual, copiamos sus elementos al nuevo arreglo
            if (this.aristasDistancias != null) {
                System.arraycopy(this.aristasDistancias, 0, nuevoArreglo, 0, this.aristasDistancias.length);
            }

            // Copiamos los nuevos elementos al nuevo arreglo
            System.arraycopy(arrDistancias, 0, nuevoArreglo, 0, arrDistancias.length);

            // Asignamos el nuevo arreglo al arreglo de la clase
            this.aristasDistancias = nuevoArreglo;
        } else {
            // Si el nuevo arreglo no es más grande, simplemente copiamos sus elementos al arreglo de la clase
            System.arraycopy(arrDistancias, 0, this.aristasDistancias, 0, arrDistancias.length);
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
    
    @Override
    public String toString() {
        return String.format("%d. %s", this.id, this.nombre);
    }
}
