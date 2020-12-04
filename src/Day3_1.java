import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

public class Day3_1 {
    public static void main(String[] args) throws Exception{
        Scanner s = new Scanner(new FileReader("input/day-3"));
        int ctr = 0;

        int y = 0;
        while (s.hasNext()) {
            ctr += s.nextLine().charAt(y) == '#' ? 1 : 0;
            y+=3;
            y%=31;
        }

        System.out.println(ctr);
    }
}
