import java.util.*;

// DIJKSTRA WITH ADJACENCY MATRIX

public class Assignment6 {

    public static void main(String[] args) {

        int n = 9;

        // Create adjacency matrix
        int[][] graph = new int[n][n];
        int INF = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            Arrays.fill(graph[i], INF);
            graph[i][i] = 0; // distance to itself = 0
        }

        // Creating Edge objects
        addEdge(graph, 0, 1, 4);
        addEdge(graph, 0, 7, 8);

        addEdge(graph, 1, 2, 8);
        addEdge(graph, 1, 7, 11);

        addEdge(graph, 2, 3, 7);
        addEdge(graph, 2, 8, 2);
        addEdge(graph, 2, 5, 4);

        addEdge(graph, 3, 4, 9);
        addEdge(graph, 3, 5, 14);

        addEdge(graph, 4, 5, 10);

        addEdge(graph, 5, 6, 2);

        addEdge(graph, 6, 7, 1);
        addEdge(graph, 6, 8, 6);

        addEdge(graph, 7, 8, 7);

        // Measure time + memory
        Runtime runtime = Runtime.getRuntime();
        long startTime = System.nanoTime();
        long startMemory = runtime.totalMemory() - runtime.freeMemory();

        int[] dist = dijkstra(graph, 0);

        long endTime = System.nanoTime();
        long endMemory = runtime.totalMemory() - runtime.freeMemory();

        long executionTime = endTime - startTime;
        long memoryUsed = endMemory - startMemory;

        // Printout Results
        printAdjList(graph);

        System.out.println("\nShortest Path from Node 0:");
        System.out.println("----------------------------");
        for (int i = 0; i < dist.length; i++) {
            System.out.println("0 → " + i + " = " + dist[i]);
        }

        System.out.println("\nExecution Time: " + executionTime + " ns");
        System.out.println("Memory Used: " + memoryUsed + " bytes");

    }

    static void printAdjList(int[][] graph) {
        int n = graph.length;
        int INF = Integer.MAX_VALUE;

        System.out.println("\nVertices   ");
        System.out.println("----------------");
        for (int i = 0; i < n; i++) {
            System.out.print(i + " ");
        }
        System.out.println("");
        System.out.println("\n Adjacency List");
        System.out.println("-----------------");
        System.out.println("Heads      Lists");

        for (int i = 0; i < n; i++) {
            System.out.print(i + "          ");
            for (int j = 0; j < n; j++) {
                if (graph[i][j] != INF && i != j) {
                    System.out.print(j + " ");
                }
            }
            System.out.println();
        }
    }

    // Add weighted edge
    static void addEdge(int[][] matrix, int u, int v, int w) {
        matrix[u][v] = w;
        matrix[v][u] = w;
    }

    // Dijkstra Computation
    static int[] dijkstra(int[][] graph, int start) {

        int n = graph.length;
        int INF = Integer.MAX_VALUE;

        int[] dist = new int[n];
        boolean[] visited = new boolean[n];

        Arrays.fill(dist, INF);
        dist[start] = 0;

        for (int count = 0; count < n - 1; count++) {

            // 1. Find closest unvisited vertex
            int u = -1;
            int smallest = INF;

            for (int i = 0; i < n; i++) {
                if (!visited[i] && dist[i] < smallest) {
                    smallest = dist[i];
                    u = i;
                }
            }

            visited[u] = true;

            // 2. Scan entire row in matrix
            for (int v = 0; v < n; v++) {
                if (!visited[v] && graph[u][v] != INF &&
                        dist[u] + graph[u][v] < dist[v]) {

                    dist[v] = dist[u] + graph[u][v];
                }
            }
        }

        return dist;
    }
}
