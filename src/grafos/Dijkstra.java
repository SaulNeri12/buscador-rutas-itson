
package grafos;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Stack;

/**
 *
 * @author saul
 */

public class Dijkstra {
    
    private int matrizAdyacencias[][];
    private int numeroVertices;

    public Dijkstra(int[][] matriz) {
        this.matrizAdyacencias = matriz;
        this.numeroVertices = matriz.length;
    }

    public ResultadoBusqueda calcularRutaMinima(int indiceInicio) {
        int arrDistancias[] = new int[numeroVertices];
        int arrPredecesores[] = new int[numeroVertices];
        
        // se rellena el arreglo con valores grandes para TODO:
        Arrays.fill(arrDistancias, Integer.MAX_VALUE);
        Arrays.fill(arrPredecesores, -1);
        
        // distancia de inicio por defecto
        arrDistancias[indiceInicio] = 0;

        PriorityQueue<Nodo> cola = new PriorityQueue<>(numeroVertices, 
                (a, b) -> Integer.compare(a.getDistancia(), b.getDistancia())
        );
        
        cola.add(new Nodo(indiceInicio, 0));

        boolean visitados[] = new boolean[numeroVertices];

        while (!cola.isEmpty()) {
            int nodoActual = cola.poll().getId();

            if (visitados[nodoActual]) continue;
            visitados[nodoActual] = true;

            for (int i = 0; i < numeroVertices; i++) {
                
                int distancia = matrizAdyacencias[nodoActual][i];
                
                if (distancia > 0 && !visitados[i] && arrDistancias[nodoActual] + distancia < arrDistancias[i]) {
                    // se suma la distancia del vertice (nodo) actual con la actual en el bucle...
                    arrDistancias[i] = arrDistancias[nodoActual] + distancia;
                    arrPredecesores[i] = nodoActual;
                    cola.add(new Nodo(i, arrDistancias[i]));
                }
            }
        }

        return new ResultadoBusqueda(arrDistancias, arrPredecesores);
    }
    
    /**
     * Devuelve la distancia entre dos nodos
     * @param idOrigen ID del nodo origen (indice en el arreglo de adyacencias)
     * @param idDestino ID del nodo destino (indice en el arreglo de adyacencias)
     * @return
     * @throws IllegalArgumentException 
     */
    public int getDistancia(int idOrigen, int idDestino) throws IllegalArgumentException {
        
        if (!(idOrigen >= 0 && idOrigen < this.matrizAdyacencias.length)) {
            throw new IllegalArgumentException("El ID del nodo de origen es incorrecto");
        }
        
        if (!(idDestino >= 0 && idDestino < this.matrizAdyacencias.length)) {
            throw new IllegalArgumentException("El ID del nodo de destino es incorrecto");
        }
        
        return this.calcularRutaMinima(idOrigen).getDistancias()[idDestino];
    }

    /**
     * Devuelve los indices (ID) de los nodos por los cuales se llega de origen a destino
     * @param idOrigen ID del nodo origen (empezando por 0)
     * @param idDestino ID del nodo destino (empezando por 0)
     * @return
     * @throws Exception 
     */
    public List<Integer> getTrazaBusquedaRutaMinima(int idOrigen, int idDestino) throws Exception {
        
        if (!(idOrigen >= 0 && idOrigen < this.matrizAdyacencias.length)) {
            throw new Exception("El ID del nodo de origen es incorrecto");
        }
        
        if (!(idDestino >= 0 && idDestino < this.matrizAdyacencias.length)) {
            throw new Exception("El ID del nodo de destino es incorrecto");
        }
        
        ResultadoBusqueda resultadoBusqueda = this.calcularRutaMinima(idOrigen);
        int arrDistancias[]     = resultadoBusqueda.getDistancias();
        int arrPredecesores[]   = resultadoBusqueda.getPredecesores();
        int distanciaMinima     = arrDistancias[idDestino];

        if (distanciaMinima == Integer.MAX_VALUE) {
            String msg = String.format(
                    "No existe una ruta que conecte al Punto(%d) origen con el Punto(%d) destino", 
                    idOrigen, 
                    idDestino
            );
            
            throw new Exception(msg);
        } 
        
        Stack<Integer> ruta = new Stack<>();
        for (int i = idDestino; i != -1; i = arrPredecesores[i]) ruta.push(i);
        

        List<Integer> rastroTraza = new ArrayList<>();
        
        while (!ruta.isEmpty()) {
            rastroTraza.add(ruta.pop());
        }
        
        return rastroTraza;
    }
}

