import java.util.Scanner;

/* задача 2 очень интересная, я смог её решить от части,
при помощи матрици смежности и алгоритма дейкстры, если ввести вершины поочерёдно,
можно найти самый маленький вес дуг, из точки 1 в последнюю.

 */
public class Task2 {
    public static void main(String[] args) {


        System.out.println("Enter num of city");
        int numOfCity = scanner();
        String[] cities = new String[numOfCity];
        int[] distance = new int[numOfCity];
        int[][] graph = new int[numOfCity][numOfCity];
        Boolean[] srt = new Boolean[numOfCity];

        inputMatrixCreate(cities, graph);


        dijkstra(distance, graph, srt, numOfCity);


        printSolution(cities, distance, numOfCity);

    }

    private static void dijkstra(int[] distance, int[][] graph, Boolean[] srt, int numOfCity) {
        for (int count = 0; count < numOfCity; count++) {
            distance[count] = Integer.MAX_VALUE;//all values are maximal
            srt[count] = false;//all values are false
        }
        distance[0] = 0; // origin point, path from origin to origin is 0

        for (int count = 0; count < numOfCity - 1; count++) {
            int minDist = minDistance(numOfCity, distance, srt);//  method returns the minimum value
            srt[minDist] = true;//permanent mark

            for (int count2 = 0; count2 < numOfCity; count2++) {

                if (!srt[count2] && graph[minDist][count2] != 0
                        && distance[minDist] != Integer.MAX_VALUE
                        && distance[minDist] + graph[minDist][count2] < distance[count2]) {
                    distance[count2] = distance[minDist] + graph[minDist][count2];//
                }
            }
        }
    }


    private static int minDistance(int numOfCity, int[] distance, Boolean[] srt) {
        int inf = Integer.MAX_VALUE;
        int minIndex = -1;
        for (int i = 0; i < numOfCity; i++) {
            if (!srt[i] && distance[i] <= inf) {
                inf = distance[i];
                minIndex = i;

            }

        }
        return minIndex;
    }


    private static void inputMatrixCreate(String[] cities, int[][] graph) {//data entry and matrix creation
        for (int i = 0; i < cities.length; i++) {
            System.out.println("Enter city name ");

            String cityName = scanString();

            cities[i] = cityName;

            System.out.println("the number of neighbors of city " + cityName);//

            int numNeighbors = scanner();

            for (int j = 0; j <= numNeighbors - 1; j++) {

                System.out.println("index cities connected to " + cityName + " the index of the first city is 1");//индексы соседей
                int indexCityNr = scanner();

                System.out.println("transportation cost");//
                int cost = scanner();

                graph[i][indexCityNr - 1] = cost;

            }

        }

        for (int[] ints : graph) {
            for (int anInt : ints) {
                System.out.print(anInt + "\t");

            }
            System.out.println();
        }
    }


    private static int scanner() {
        Scanner scan = new Scanner(System.in);
        int num = scan.nextInt();
        if (num <= 0) {
            System.out.println("You entered a negative number");
            return scanner();
        }
        return num;
    }

    private static void printSolution(String[] cities, int[] distance, int numOfCity) {
        System.out.println("Distance from Source");
        for (int i = 0; i < numOfCity; i++)
            System.out.println(cities[i] + " \t " + distance[i]);
    }


    private static String scanString() {
        Scanner scanString = new Scanner(System.in);
        return scanString.next();

    }
}
