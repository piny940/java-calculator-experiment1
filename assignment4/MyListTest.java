import java.util.LinkedList;
import java.util.Scanner;

public class MyListTest {
    private static final Integer FIRST_INPUT_TIME = 10;
    private static final Integer INSERT_TIME = 10;
    private static final Integer DELETE_TIME = 10;

    public static void main(String[] args) {
        LinkedList<Integer> linkedList = new LinkedList<>();
        MyList myList = new MyList();

        for (int i = 0; i < FIRST_INPUT_TIME; i++) {
            Integer input = getNatInput();
            linkedList.add(input);
        }
        myList.output(linkedList);

        for (int i = 0; i < INSERT_TIME; i++) {
            Integer input = getNatInput();
            myList.insert(input, linkedList);
            myList.output(linkedList);
        }

        for (int i = 0; i < DELETE_TIME; i++) {
            Integer input = getNatInput();
            myList.delete(input, linkedList);
            myList.output(linkedList);
        }
    }

    public static Integer getNatInput() {
        try {
            Scanner scanner = new Scanner(System.in);
            String inputString = scanner.nextLine();
            System.out.println(inputString);
            Integer input = Integer.parseInt(inputString);

            scanner.close();

            if (input <= 0) {
                System.out.println("Input must be natural numbers");
            }

            return input;
        } catch (NumberFormatException ex) {
            System.out.println("Cannot convert to integer");
            System.exit(0);

            return 0;
        }
    }
}
