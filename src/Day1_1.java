import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

public class Day1_1 {
    public static void main(String[] args) throws Exception{
        Scanner s = new Scanner(new FileReader("input/day-1"));
        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(s.nextInt());

        while (s.hasNext()) {
            int num = s.nextInt();
            for (Integer integer : arr) {
                if (num + integer == 2020) {
                    System.out.println(num + " " + integer);
                    System.out.println(num*integer);
                }
            }
            arr.add(num);
        }
    }
}
