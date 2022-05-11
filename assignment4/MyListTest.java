import java.util.LinkedList;
import java.util.Scanner;

public class MyListTest {
    private static final Integer FIRST_INPUT_TIME = 10;
    private static final Integer INSERT_TIME = 10;
    private static final Integer DELETE_TIME = 10;

    public static void main(String[] args) {
        LinkedList<Integer> linkedList = new LinkedList<>();
        MyList myList = new MyList();

        try {
            Scanner scanner = new Scanner(System.in);

            for (int i = 0; i < FIRST_INPUT_TIME; i++) {
                Integer input = getNatInput(scanner);
                linkedList.add(input);
            }
            myList.output(linkedList);

            for (int i = 0; i < INSERT_TIME; i++) {
                Integer input = getNatInput(scanner);
                myList.insert(input, linkedList);
                myList.output(linkedList);
            }

            for (int i = 0; i < DELETE_TIME; i++) {
                Integer input = getNatInput(scanner);
                myList.delete(input, linkedList);
                myList.output(linkedList);
            }

            scanner.close();
        }
        catch (RuntimeException ex) {
            System.out.println(ex.getMessage());
            System.exit(0);
        }
    }

    public static Integer getNatInput(Scanner scanner) {
        try {
            String inputString = scanner.next();
            Integer input = Integer.parseInt(inputString);
            
            if (input <= 0) {
                System.out.println("Input must be natural numbers");
                System.exit(0);
            }

            return input;
        } catch (NumberFormatException ex) {
            System.out.println("Cannot convert to integer");
            System.exit(0);

            return 0;
        }
    }
}
