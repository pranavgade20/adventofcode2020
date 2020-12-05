import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

public class Day5_2 {
    public static void main(String[] args) throws Exception{
        Scanner s = new Scanner(new FileReader("input/day-5"));
        int[] filled = new int[1024];

        while (s.hasNext()) {
            int num = 0;
            String l = s.nextLine();

            for (int i = 0; i < 7; i++) {
                num += l.charAt(i) == 'B' ? 1 : 0;
                num *= 2;
            }
            for (int i = 7; i < 10; i++) {
                num += l.charAt(i) == 'R' ? 1 : 0;
                num *= 2;
            }
            num/=2;
            filled[num] = 1;
        }

        for (int i = 1; i < filled.length-1; i++) {
            if (filled[i] == 0) {
                if (filled[i-1] == 1 && filled[i+1] == 1) {
                    System.out.println(i);
                }
            }
        }
    }
}
