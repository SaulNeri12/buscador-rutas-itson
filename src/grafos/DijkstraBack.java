package grafos;

//Programa en Java para el algoritmo de Dijkstra que encuentra

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

//el camino mas corto para un unico origen
//Se emplea una matrix de adjacencia para representar el grafo

public class DijkstraBack {

    // Numero de vertices en el grafo
    static final int V = 9;

    // Funcion utilitaria para encontrar el vertice con la distancia minima, 
    // a partir del conjunto de los vertices todavia no incluidos en el 
    // camino mas corto
    private static int minDistance(int[] dist, boolean[] verticeYaProcesado) {
        // Initialize min value
        int min = Integer.MAX_VALUE;
        int min_index = 0;

        for (int v = 0; v < V; v++) {
            if (verticeYaProcesado[v] == false && dist[v] <= min) {
                min = dist[v];
                min_index = v;
            }
        }

        return min_index;
    }

    // Funcion utilitaria para imprimir el arreglo de distancias calculadas
    private static void printSolution(int[] dist, int n) {
        System.out.println("Distancia del vertice desde el origen\n");
        for (int i = 0; i < V; i++) {
            System.out.println(i + " \t\t " + dist[i]);
        }
    }

    private static void dijkstra(int[][] grafo, int src) {
        int[] dist = new int[V];
        // dist[i] guarda la distancia mas corta desde src hasta el vertice i

        boolean[] verticeYaProcesado = new boolean[V];
        //Este arreglo tiene true si el vertice i ya fue procesado

        // Initialize all distances as INFINITE and stpSet[] as false
        for (int i = 0; i < V; i++) {
            dist[i] = Integer.MAX_VALUE;
            verticeYaProcesado[i] = false;
        }
        // La distancia del vertice origen hacia el mismo es siempre 0
        dist[src] = 0;

        //Encuentra el camino mas corto para todos los vertices
        for (int count = 0; count < V - 1; count++) {

            //Toma el vertice con la distancia minima del cojunto de vertices aun no procesados
            //En la primera iteracion siempre se devuelve src
            int u = minDistance(dist, verticeYaProcesado);

            // Se marca como ya procesado
            verticeYaProcesado[u] = true;

            // Update dist value of the adjacent vertices of the picked vertex.
            for (int v = 0; v < V; v++) //Se actualiza la dist[v] solo si no esta en verticeYaProcesado, hay un
            //arco desde u a v y el peso total del camino desde src hasta v a traves de u es 
            // mas pequeno que el valor actual de dist[v]
            {
                if (!verticeYaProcesado[v] && grafo[u][v] > 0 && dist[u] != Integer.MAX_VALUE
                        && dist[u] + grafo[u][v] < dist[v]) {
                    dist[v] = dist[u] + grafo[u][v];
                }
            }
        }

        // se imprime el arreglo con las distancias
        printSolution(dist, V);
}
    private static int calcularDistancia(int[][] grafo, int idOrigen, int idDestino) throws IllegalArgumentException {
        int V = grafo.length;
        int[] dist = new int[V];
        boolean[] verticeYaProcesado = new boolean[V];

        for (int i = 0; i < V; i++) {
            dist[i] = Integer.MAX_VALUE;
            verticeYaProcesado[i] = false;
        }

        dist[idOrigen] = 0;

        for (int count = 0; count < V - 1; count++) {
            int u = minDistance(dist, verticeYaProcesado);
            verticeYaProcesado[u] = true;

            for (int v = 0; v < V; v++) {
                if (!verticeYaProcesado[v] && grafo[u][v] > 0 && dist[u] != Integer.MAX_VALUE
                        && dist[u] + grafo[u][v] < dist[v]) {
                    dist[v] = dist[u] + grafo[u][v];
                }
            }
        }
        
        return dist[idDestino];
    } 

    // TODO: No traza bien las rutas de los indices de los pesos de las aristas, marca una
    // ruta erronea.
    public static void dijkstra(int[][] grafo, int src, int dest, List<Integer> nodosVisitados) {
        int V = grafo.length;
        int[] dist = new int[V];
        
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;

        PriorityQueue<Integer> colaPrioridad = new PriorityQueue<>((a, b) -> dist[a] - dist[b]);
        colaPrioridad.add(src);

        while (!colaPrioridad.isEmpty()) {
            int u = colaPrioridad.poll();
            
            nodosVisitados.add(u);

            for (int v = 0; v < V; v++) {
                if (grafo[u][v] > 0 && dist[u] != Integer.MAX_VALUE && dist[u] + grafo[u][v] < dist[v]) {
                    dist[v] = dist[u] + grafo[u][v];
                    colaPrioridad.add(v);
                }
            }
        }

        System.out.println("Distancia mínima desde " + src + " hasta " + dest + ": " + dist[dest]);
    }

    
    
// driver program to test above function
public static void main(String[] args)
{
   int[][] graph = {  {0, 4, 0, 0, 0, 0, 0, 8, 0},
                      {4, 0, 8, 0, 0, 0, 0, 11, 0},
                      {0, 8, 0, 7, 0, 4, 0, 0, 2},
                      {0, 0, 7, 0, 9, 14, 0, 0, 0},
                      {0, 0, 0, 9, 0, 10, 0, 0, 0},
                      {0, 0, 4, 0, 10, 0, 2, 0, 0},
                      {0, 0, 0, 14, 0, 2, 0, 1, 6},
                      {8, 11, 0, 0, 0, 0, 1, 0, 7},
                      {0, 0, 2, 0, 0, 0, 6, 7, 0}
                     };
 
    dijkstra(graph, 0);
    System.out.println("--------------------------------");
    dijkstra(graph, 1);
    
    List<Integer> visitados = new ArrayList<>();
    
    dijkstra(graph, 0, 4, visitados);
    
    System.out.println(visitados);
    
    System.out.println();
}
}