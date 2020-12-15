import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class Day13_2 {
    public static void main(String[] args) throws Exception{
        Scanner s = new Scanner(new FileReader("input/day-13"));

        int res = 0;

        double min = Integer.parseInt(s.nextLine());
        ArrayList<int[]> departs = new ArrayList<>();
        int h = 0;
        for (String d : s.nextLine().split(",")) {
            if (!d.equals("x")) {
                departs.add(new int[]{Integer.parseInt(d), h%Integer.parseInt(d)});
            }
            h++;
        }

         departs.sort(Comparator.comparing(a -> -a[0]));

        long additive = 1;
        long target = 0;

        for (int[] depart : departs) {
            while (target%depart[0] != depart[1]) {
                target += additive;
            }
            additive *= depart[0];
        }

        System.out.println(target);
        System.out.println(target%additive);
    }
}

