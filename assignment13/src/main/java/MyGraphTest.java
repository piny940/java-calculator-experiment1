import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;

public class MyGraphTest {
    public static void main(String[] args) {
        try {
            String graphFilename = args[0];
            String coordsFilename = args[1];
            int startLongitude = Integer.parseInt(args[2]);
            int startLatitude = Integer.parseInt(args[3]);
            int endLongitude = Integer.parseInt(args[4]);
            int endLatitude = Integer.parseInt(args[5]);
            String resultFilename = args[6];

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
        catch (NoSuchElementException ex) {
            System.out.println("The actual number of edges given is less than the number of edges specified in the file.");
            System.exit(0);
        }
        catch (RuntimeException ex) {
            System.out.println(ex.getMessage());
            System.exit(0);
        }
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
