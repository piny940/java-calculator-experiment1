import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;

public class MyGraphTest {
    public static void main(String[] args) {
        try {
            String graphFilename = args[0];
            String coordsFilename = args[1];
            int startLongitude = (int)(Double.parseDouble(args[2]) * 1000000);
            int startLatitude = (int)(Double.parseDouble(args[3]) * 1000000);
            int endLongitude = (int)(Double.parseDouble(args[4]) * 1000000);
            int endLatitude = (int)(Double.parseDouble(args[5]) * 1000000);
            String resultFilename = args[6];
            // String graphFilename = "ny-distance-graph.txt";
            // String coordsFilename = "ny-coords.txt";
            // int startLongitude = (int) (Double.parseDouble("-74.006218") * 1000000);
            // int startLatitude = (int) (Double.parseDouble("40.471788") * 1000000);
            // int endLongitude = (int) (Double.parseDouble("-73.737119") * 1000000);
            // int endLatitude = (int) (Double.parseDouble("40.589291") * 1000000);
            // String resultFilename = "result.txt";

            MyGraph graph = new MyGraph();
            graph.readFromFile(graphFilename);

            CoordsManager coordsManager = new CoordsManager();
            coordsManager.readFromFile(coordsFilename);
            int start = coordsManager.getClosestNode(startLongitude, startLatitude);
            int end = coordsManager.getClosestNode(endLongitude, endLatitude);

            Integer[] prevs = graph.getShortestPath(start, end);
            Integer point = end;
            Integer weightSum = 0;
            ArrayList<Integer> path = new ArrayList<>();
            path.add(0, end);

            while (true) {
                if (point == start) {
                    break;
                }

                if (prevs[point] == null) {
                    String message = "The start and end points are not connected.";
                    throw new RuntimeException(message);
                }
                weightSum += graph.getWeight(point, prevs[point]);
                point = prevs[point];
                path.add(0, point);
            }

            String[] lines = new String[path.size()];

            for (int i = 0; i < path.size(); i++) {
                Coord coord = coordsManager.getCoord(path.get(i));
                lines[i] = String.format("%d %d", coord.getLongitude(), coord.getLatitude());
            }
            outputLines(resultFilename, lines);
        }
        catch (InputMismatchException ex) {
            System.out.println(ex.getMessage());
            System.exit(0);
        }
        // catch (NoSuchElementException ex) {
        //     System.out.println("The actual number of edges given is less than the number of edges specified in the file.");
        //     System.exit(0);
        // }
        // catch (RuntimeException ex) {
        //     System.out.println(ex.getMessage());
        //     System.exit(0);
        // }
    }

    private static void outputLines(String outputFilename, String[] lines) {
        try {
            File outputFile = new File(outputFilename);
            FileWriter writer = new FileWriter(outputFile);
            for (int i = 0; i < lines.length; i++) {
                writer.write(lines[i] + "\n");
            }

            writer.close();
        } catch (IOException ex) {
            System.out.println("Failed to write file");
            System.exit(0);
        }
    }
}
