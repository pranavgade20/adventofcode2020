import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

public class Day1_2 {
    public static void main(String[] args) throws Exception{
        Scanner s = new Scanner(new FileReader("input/day-1"));
        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(s.nextInt());

        while (s.hasNext()) {
            int num = s.nextInt();
            for (Integer integer : arr) {
                for (Integer integer1 : arr) {
                    if (num + integer + integer1 == 2020) {
                        System.out.println(num + " " + integer + " " + integer1);
                        System.out.println(num*integer*integer1);
                    }
                }
            }
            arr.add(num);
        }
    }
}
