import java.util.ArrayList;
import java.util.Random;

public class Example {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();

        // Adding 100 random elements to the list
        Random random = new Random();
        for (int i = 0; i < 100; i++) {
            int randomNumber = random.nextInt(1000);
            list.add(randomNumber);
        }

        Quicksort<Integer> sortInt = new Quicksort<>(new Quicksort.Bigger<Integer>() {
            @Override
            public Integer bigger(Integer elementOne, Integer elementTwo) {
                return elementOne>elementTwo ? elementOne : elementTwo;
            }
        });

        System.out.println("Sorted List: " + sortInt.sort(list));
    }
}